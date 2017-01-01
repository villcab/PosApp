package bo.com.ahosoft.activitys;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

import bo.com.ahosoft.R;
import bo.com.ahosoft.datas.DRecord;
import bo.com.ahosoft.entitys.Record;
import bo.com.ahosoft.utils.App;
import bo.com.ahosoft.utils.DateSQLite;
import bo.com.ahosoft.utils.reflextion.Action;

public class RecordActivity extends AppCompatActivity {

    private TextView tvDescripcion;
    private TextView tvAmount;

    private Record record = new Record();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.record_activity);

        setToolbar();

        tvDescripcion = (TextView) findViewById(R.id.description);
        tvAmount = (TextView) findViewById(R.id.amount);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            Long recordId = bundle.getLong("id");
            if (recordId != null) {
                try {
                    DRecord data = new DRecord(this, Record.class);
                    record = data.findById(recordId);

                    tvDescripcion.setText(record.getDescription());
                    tvAmount.setText(record.getAmount().toString());

                } catch (Exception e) {
                    Log.e(App.TAG, "Error al cargar: " + e);
                }
            }
        }

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

    public void saveRecord(View view) {
        save();
    }

    public void save() {
        if (validateField()) {
            try {
                record.setDescription(tvDescripcion.getText().toString());
                record.setAmount(Double.valueOf(tvAmount.getText().toString()));

                DRecord data = new DRecord(this, Record.class);

//                if (data.searchByNombre(entity.getNombre().trim())) {
//                    Toast.makeText(this, "Ya existe un concepto con el nombre indicado", Toast.LENGTH_SHORT).show();
//
//                } else {
                if (record.getId() != null) {
                    record.setAction(Action.UPDATE);

                } else {
                    record.setAction(Action.INSERT);
                    record.setDate(new Date());
                    record.setCreatedAt(DateSQLite.nowDate());
                }

                data.save(record);
                Log.e(App.TAG, "Record inserted");
                Toast.makeText(this, "Registro guardado correctamente", Toast.LENGTH_SHORT).show();
                finish();

//                }

            } catch (Exception e) {
                e.printStackTrace();
                Log.e(App.TAG, "Error al guardar el registro: " + e.toString());
            }
        }
    }

    private boolean validateField() {
        boolean sw = true;
        if (tvDescripcion.getText().toString().isEmpty()) {
            Toast.makeText(this, "Descripcion necesita un valor", Toast.LENGTH_SHORT).show();
            sw = false;
        } else if (tvAmount.getText().toString().isEmpty()) {
            Toast.makeText(this, "Monto necesita un valor", Toast.LENGTH_SHORT).show();
            sw = false;
        } else {
            try {
                Double.parseDouble(tvAmount.getText().toString());
            } catch (Exception e) {
                Toast.makeText(this, "Monto formato no valido", Toast.LENGTH_SHORT).show();
                sw = false;
            }
        }
        return sw;
    }

    public void remove() {
        try {
            DRecord data = new DRecord(this, Record.class);
            record.setAction(Action.DELETE);
            data.save(record);
            Toast.makeText(this, "Registro eliminado correctamente!", Toast.LENGTH_SHORT).show();
            finish();

        } catch (Exception e) {
            Log.e(App.TAG, "Error al eliminar el registro: " + e.toString());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_crud, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem item = menu.findItem(R.id.action_remove);
        if (record.getId() == null) {
            item.setVisible(false);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Log.e(App.TAG, "Id: " + id);
        switch (id) {
            case R.id.action_save:
                save();
                break;
            case R.id.action_remove:
                remove();
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
