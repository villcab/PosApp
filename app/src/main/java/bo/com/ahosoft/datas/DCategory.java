package bo.com.ahosoft.datas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.List;

import bo.com.ahosoft.entitys.Category;
import bo.com.ahosoft.utils.App;
import bo.com.ahosoft.utils.reflextion.Wrapper;

public class DCategory extends Wrapper {

    public DCategory(Context context, Class type) throws Exception {
        super(context, type);
    }

    public DCategory(Context context, SQLiteDatabase connection) {
        super(context, connection);
    }

    public List<Category> listAll() {
        String query = String.format("SELECT * FROM %s ORDER BY id DESC", tableName);
        Log.d(App.TAG, query);
        List<Category> list = this.list(query, new Category());
        return list;
    }
}
