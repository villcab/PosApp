package bo.com.ahosoft.datas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import bo.com.ahosoft.entitys.Record;
import bo.com.ahosoft.utils.App;
import bo.com.ahosoft.utils.DateSQLite;
import bo.com.ahosoft.utils.reflextion.Wrapper;

public class DRecord extends Wrapper {

    public DRecord(Context context, Class type) throws Exception {
        super(context, type);
    }

    public DRecord(Context context, SQLiteDatabase connection) {
        super(context, connection);
    }

    public List<Record> listByDate(Date date) {
        String query = String.format("SELECT * FROM %s WHERE createdAt = '%s' ORDER BY id DESC", tableName, DateSQLite.formatDate(date));
        //String query = String.format("SELECT * FROM %s ORDER BY id DESC", tableName);
        Log.e(App.TAG, query);
        List<Record> list = this.list(query, new Record());
        return list;
    }

    public Record findById(Long id) {
        String query = String.format("SELECT * FROM %s WHERE id = %s", tableName, id);
        Log.d(App.TAG, query);
        List<Record> list = this.list(query, new Record());
        return list.isEmpty() ? null : list.get(0);
    }
}
