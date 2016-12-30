package bo.com.ahosoft.utils.reflextion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.util.Log;

import com.googlecode.openbeans.PropertyDescriptor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import bo.com.ahosoft.entitys.Category;
import bo.com.ahosoft.entitys.Record;
import bo.com.ahosoft.entitys.inventory.Product;
import bo.com.ahosoft.utils.App;
import bo.com.ahosoft.utils.reflextion.annotations.Ignored;
import bo.com.ahosoft.utils.reflextion.annotations.Key;
import bo.com.ahosoft.utils.reflextion.annotations.TableName;

public abstract class Wrapper extends SQLiteOpenHelper {

    private SQLiteDatabase connection = null;

    protected Context context;

    public String tableName;

    public Wrapper(Context context, Class type) throws Exception {
        super(context, Setting.databaseName, null, 1);
        this.context = context;
        tableName = getTableName(type);
    }

    public Wrapper(Context context, SQLiteDatabase connection) {
        super(context, Setting.databaseName, null, 1);
        this.connection = connection;
    }

    public int count(String strQuery) {
        SQLiteDatabase objDB = this.getReadableDatabase();
        Cursor cursor = null;
        int count = 0;
        try {
            cursor = objDB.rawQuery(strQuery, new String[]{});
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    count = cursor.getInt(0);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            objDB.close();
        }
        return count;
    }

    public void clean(Entity entity) {
        SQLiteDatabase objDb = this.getWritableDatabase();
        try {
            objDb.beginTransaction();
            objDb.delete(tableName, "", new String[]{});
            objDb.setTransactionSuccessful();
        } catch (Exception e) {
            Log.e(App.TAG, e.getMessage());
        } finally {
            objDb.endTransaction();
            objDb.close();
        }
    }

    private static boolean Ignore(Field field) {
        if (field.getName().equalsIgnoreCase("$change") || field.getName().equalsIgnoreCase("serialVersionUID")) {
            return true;

        } else {
            Annotation[] annotations = field.getAnnotations();
            if (annotations.length > 0) {
                for (Annotation annotation : annotations) {
                    if (annotation instanceof Ignored) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public void save(Entity entity) throws Exception {
//        boolean result = false;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values;
        try {
            db.beginTransaction();
            values = new ContentValues();
            Field[] entityFields = entity.getClass().getDeclaredFields();
            Field[] superFields = entity.getClass().getSuperclass().getDeclaredFields();
            List<Field> listFields = new ArrayList<Field>();
            listFields.addAll(Arrays.asList(entityFields));
            listFields.addAll(Arrays.asList(superFields));

//            String fieldKey = null;
            Field fieldKey = null;

            for (Field field : listFields) {
                Key key = field.getAnnotation(Key.class);
                if (key != null) {
                    fieldKey = field;
                    continue;
                }
                if (!Ignore(field)) {
                    PropertyDescriptor prop = new PropertyDescriptor(field.getName(), entity.getClass());
//                    try {
//                        prop = new PropertyDescriptor(field.getName(), entity.getClass());
//                    } catch (NullPointerException e) {
//                        prop = new PropertyDescriptor(field.getName(), entity.getClass().getSuperclass());
//                    }

                    Method method = prop.getReadMethod();
                    Object value = method.invoke(entity);
                    if (value != null) {
                        values.put(field.getName(), value.toString());
                    }
                    // REVISAR ESTA SENTENCIA ELSE AGREGADA PARA EVITAR QUE ALGUN CAMPO CON VALOR NULO NO SE INSERTE
                    //else {
                    //values.put(field.getName(), "null");
                    //}
                }
            }

            if (fieldKey == null) {
                throw new Exception("No Existe la anotacion @Key en la entidad: " + entity.getClass());
            }

            PropertyDescriptor propertyDescriptor;
            Method method;
            Object value;
            switch (entity.getAction()) {
                case INSERT:
                    Long id = db.insert(tableName, null, values);
                    propertyDescriptor = new PropertyDescriptor(fieldKey.getName(), entity.getClass());
                    method = propertyDescriptor.getWriteMethod();
                    method.invoke(entity, id);
                    break;

                case UPDATE:
                    propertyDescriptor = new PropertyDescriptor(fieldKey.getName(), entity.getClass());
                    method = propertyDescriptor.getReadMethod();
                    value = method.invoke(entity);
                    db.update(tableName, values, "id = ?", new String[]{value.toString()});
                    break;
                case DELETE:
                    propertyDescriptor = new PropertyDescriptor(fieldKey.getName(), entity.getClass());
                    method = propertyDescriptor.getReadMethod();
                    value = method.invoke(entity);
                    db.delete(tableName, "id = ?", new String[]{value.toString()});
                    break;
                default:
                    throw new Exception("Especifique INSERT, UPDATE OR DELETE");
            }

//            if (entity.getAction() == Action.INSERT) {
//                Long id = db.insert(table, null, values);
//
//            } else if (entity.getAction() == Action.UPDATE) {
//                db.update(table, values, "id=?", new String[]{Long.toString(entity.getId())});
//            } else {
//                db.delete(table, "id=?", new String[]{Long.toString(entity.getId())});
//            }

            db.setTransactionSuccessful();
//            result = true;
        } finally {
            db.endTransaction();
            db.close();
        }

//        return result;
    }

    protected <T extends Entity> List<T> list(String query, Entity entity) {
        List<T> lstResult = new ArrayList<T>();
        SQLiteDatabase objDb = this.getReadableDatabase();
        Cursor cursor = null;
        try {
            cursor = objDb.rawQuery(query, new String[]{});
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    lstResult.add((T) this.load(cursor, entity).getClone());
                }
                cursor.close();
            }
        } catch (Exception e) {
            Log.e(App.TAG, e.getMessage());
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        objDb.close();
        this.close();
        return lstResult;
    }

    protected List<Map> genericList(String strQuery) {
        List<Map> lstResult = new ArrayList<Map>();
        Map obj;
        SQLiteDatabase objDb = this.getReadableDatabase();
        Cursor cursor = null;
        try {
            cursor = objDb.rawQuery(strQuery, new String[]{});
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    obj = new HashMap();
                    for (int index = 0; index < cursor.getColumnCount(); index++) {
                        obj.put(cursor.getColumnName(index), cursor.getString(index));
                    }
                    lstResult.add(obj);
                }
                cursor.close();
            }
        } catch (Exception e) {
            Log.e(App.TAG, e.getMessage());
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        objDb.close();
        this.close();
        return lstResult;
    }

    public <T extends Entity> T load(Cursor cursor, Entity entity) {
        T obj = (T) entity;
        Field[] fields = obj.getClass().getDeclaredFields();
        Field[] superFields = obj.getClass().getSuperclass().getDeclaredFields();
        List<Field> listFields = new ArrayList<Field>();
        listFields.addAll(Arrays.asList(fields));
        listFields.addAll(Arrays.asList(superFields));
        try {
            for (Field field : listFields) {
                if (!Ignore(field)) {
                    PropertyDescriptor prop;
                    try {
                        prop = new PropertyDescriptor(field.getName(), obj.getClass());
                    } catch (NullPointerException e) {
                        prop = new PropertyDescriptor(field.getName(), obj.getClass().getSuperclass());
                    }
                    Method method = prop.getWriteMethod();

                    if (method != null) {
                        Type type = field.getGenericType();
                        if (type.toString().equals(String.class.toString())) {
                            String value = cursor.getString(cursor.getColumnIndex(field.getName()));
                            method.invoke(obj, new Object[]{value});
                        } else if (type.toString().equals(Long.class.toString())) {
                            Long value = cursor.getLong(cursor.getColumnIndex(field.getName()));
                            method.invoke(obj, new Object[]{value});
                        } else if (type.toString().equals(Integer.class.toString())) {
                            Integer value = cursor.getInt(cursor.getColumnIndex(field.getName()));
                            method.invoke(obj, new Object[]{value});
                        } else if (type.toString().equals(Double.class.toString())) {
                            Double value = cursor.getDouble(cursor.getColumnIndex(field.getName()));
                            method.invoke(obj, new Object[]{value});
                        } else if (type.toString().equals(Date.class.toString())) {
                            String value = cursor.getString(cursor.getColumnIndex(field.getName()));
                            Date dateValue = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy", Locale.US).parse(value);
                            method.invoke(obj, new Object[]{dateValue});
                        }

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) obj;
    }

    protected static String concatKeys(List<Object> Llaves) {
        return ((Llaves.size() > 0) ? "(" + TextUtils.join(", ", Llaves) + ")" : "(o)");
    }

    protected static String concatKeysLong(List<Long> Llaves) {
        return ((Llaves.size() > 0) ? "(" + TextUtils.join(", ", Llaves) + ")" : "(0)");
    }

    public static String getTableName(Class type) throws Exception {
        TableName table = (TableName) type.getAnnotation(TableName.class);
        if (table == null) {
            throw new Exception("No existe la anotacion @TableName en la Entidad: " + type.getSimpleName());
        }
        return table.name();
    }

    public <T extends Entity> T get(String strQuery, Entity entity) {
        SQLiteDatabase objDb = this.getReadableDatabase();
        Cursor cursor = null;
        try {
            cursor = objDb.rawQuery(strQuery, new String[]{});
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    entity = (T) this.load(cursor, entity);
                }
                cursor.close();
            }
        } catch (Exception e) {
            Log.e(App.TAG, e.getMessage());
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        objDb.close();
        this.close();
        return (T) entity;
    }

    public String createTable(Entity entity) throws Exception {
        Field[] fields = entity.getClass().getDeclaredFields();
        Field[] superFields = entity.getClass().getSuperclass().getDeclaredFields();
        List<Field> listFields = new ArrayList<Field>();
        listFields.addAll(Arrays.asList(fields));
        listFields.addAll(Arrays.asList(superFields));
        fields = new Field[listFields.size()];
        fields = listFields.toArray(fields);
        List<Object> columns = new ArrayList<Object>();
        StringBuilder builder = new StringBuilder();
        builder.append("CREATE TABLE ");
        builder.append(getTableName(entity.getClass()));
        try {
            for (Field field : fields) {
                if (!(field.getName().equals("action"))) {
                    if (!Ignore(field)) {
                        Annotation[] annotations = field.getAnnotations();
                        if (annotations.length > 0) {
                            for (Annotation annotation : annotations) {
                                if (annotation instanceof Key) {
                                    columns.add(field.getName() + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT");
                                    //} else if (annotation instanceof Nullable) {
                                    //    columns.add(field.getName() + " text");
                                } else {
                                    //columns.add(field.getName() + " text NOT NULL");
                                    columns.add(field.getName() + " TEXT");
                                }
                            }
                        } else {
                            columns.add(field.getName() + " TEXT");
                        }
                    }
                }

            }
            builder.append(concatKeys(columns));
            Log.i(App.TAG, builder.toString());
            return builder.toString();
        } catch (Exception e) {
            Log.e(App.TAG, e.getMessage());
        }
        return "";
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(createTable(new Product()));
            db.execSQL(createTable(new Category()));
            db.execSQL(createTable(new Record()));
        } catch (Exception e) {
            Log.e(App.TAG, "Error al crear las tablas", e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public SQLiteDatabase getConnection() {
        return connection;
    }

    public void setConnection(SQLiteDatabase connection) {
        this.connection = connection;
    }

    public void openTransaction() {
        connection = this.getWritableDatabase();
        connection.beginTransaction();
    }

    public void transactionSuccesfully() {
        connection.setTransactionSuccessful();
    }

    public void closeTransaction() {
        connection.endTransaction();
        connection.close();
    }

}