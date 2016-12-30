package bo.com.ahosoft.activitys;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import bo.com.ahosoft.R;
import bo.com.ahosoft.datas.DCategory;
import bo.com.ahosoft.entitys.Category;
import bo.com.ahosoft.utils.App;
import bo.com.ahosoft.utils.reflextion.Action;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        setToolbar();
    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        toolbar.setTitleTextColor(getResources().getColor(R.color.colorPrimaryDark));
        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            // Poner ícono del drawer toggle
            ab.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }

    public void save() {
        TextView tvNombre = (TextView) findViewById(R.id.description);
        TextView tvDescripcion = (TextView) findViewById(R.id.description);

        Category entity = new Category();
        entity.setName(tvNombre.getText().toString());
        //entity.setDescriptioncion(tvDescripcion.getText().toString());

        if (!entity.getName().isEmpty()) {
            DCategory data = null;
            try {
                data = new DCategory(this, Category.class);

//                if (data.searchByNombre(entity.getNombre().trim())) {
//                    Toast.makeText(this, "Ya existe un concepto con el nombre indicado", Toast.LENGTH_SHORT).show();
//
//                } else {
                    entity.setAction(Action.INSERT);
                    data.save(entity);
                    Toast.makeText(this, "Registro guardado correctamente", Toast.LENGTH_SHORT).show();
                    finish();
//                }

            } catch (Exception e) {
                e.printStackTrace();
                Log.e(App.TAG, "Error al guardar el registro: " + e.toString());
            }

        } else {
            Toast.makeText(this, "Nombre no puede ser vacio", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_crud, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Log.e(App.TAG, "Id: " + id);
        switch (id) {
            case R.id.action_save:
                save();
                break;
            case 16908332:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
