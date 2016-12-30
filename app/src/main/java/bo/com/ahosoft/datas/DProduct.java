package bo.com.ahosoft.datas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.List;

import bo.com.ahosoft.entitys.inventory.Product;
import bo.com.ahosoft.utils.App;
import bo.com.ahosoft.utils.reflextion.Wrapper;

public class DProduct extends Wrapper {

    public DProduct(Context context, Class type) throws Exception {
        super(context, type);
    }

    public DProduct(Context context, SQLiteDatabase connection) {
        super(context, connection);
    }

    public List<Product> listAll() {
        String query = String.format("SELECT * FROM %s ORDER BY id DESC", tableName);
        Log.d(App.TAG, query);
        List<Product> list = this.list(query, new Product());
        return list;
    }
}
