package bo.com.ahosoft.activitys.fragments;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import bo.com.ahosoft.R;
import bo.com.ahosoft.activitys.RecordActivity;
import bo.com.ahosoft.adapters.RecordAdapter;
import bo.com.ahosoft.datas.DRecord;
import bo.com.ahosoft.entitys.Record;
import bo.com.ahosoft.utils.App;
import bo.com.ahosoft.utils.DateSQLite;

public class RecordFragment extends Fragment {

    private RecordFragment fragment = this;

    private View view;

    public static final String ARG_SECTION_TITLE = "section_number";

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private List<Record> entitys;

    private Double total;
    private Calendar date;

    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    private AdapterView.OnItemClickListener listener;

    private TextView tvTotal;
    private TextView tvDate;

    public static RecordFragment newInstance(String sectionTitle) {
        RecordFragment fragment = new RecordFragment();
        Bundle args = new Bundle();
        args.putString(ARG_SECTION_TITLE, sectionTitle);
        fragment.setArguments(args);
        Log.e(App.TAG, "NEWINSTANCE");
        return fragment;
    }

    public RecordFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_record, container, false);

        recycler = (RecyclerView) view.findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(view.getContext());
        recycler.setLayoutManager(layoutManager);
        recycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(App.TAG, "Selected: " + view);
            }
        });

        listener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e(App.TAG, "Selected adater: " + view);
            }
        };

        tvTotal = (TextView) view.findViewById(R.id.total);
        tvDate = (TextView) view.findViewById(R.id.date);

        date = Calendar.getInstance(TimeZone.getTimeZone("GTM-4"));
        setDate();

        FloatingActionButton button = (FloatingActionButton) view.findViewById(R.id.btn_filter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(App.TAG, "Click in filter");
                openDatePicker();
            }
        });

        Log.e(App.TAG, "ONCREATEVIEW");

        // Crear un nuevo adaptador
        /*adapter = new CategoriaAdapter(entitys);
        recycler.setAdapter(adapter);*/
        return view;
    }

    @Override
    public void onResume() {
        loadEntitys();
        Log.e(App.TAG, "ONRESUME");
        super.onResume();
    }

    private void loadEntitys() {
        try {
            DRecord data = new DRecord(view.getContext(), Record.class);
            entitys = data.listByDate(date.getTime());
            sumarTotal();

            for (Record item : entitys) {
                Log.e(App.TAG, item.toString());
            }

        } catch (Exception e) {
            Log.e(App.TAG, "Error al cargar la entidades: " + e.toString());
        }
        adapter = new RecordAdapter(entitys, fragment);
        recycler.setAdapter(adapter);
    }

    public void onItemClick(int position) {
        Log.e(App.TAG, "ON ITEM CLICK FRAMENT: " + position);

        Record r = entitys.get(position);

        Bundle bundle = new Bundle();
        bundle.putLong("id", r.getId());
        Intent intent = new Intent(this.getContext(), RecordActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void sumarTotal() {
        if (entitys.isEmpty()) {
            total = 0D;
        } else {
            total = 0D;
            for (Record item : entitys) {
                total += item.getAmount();
            }
        }
        tvTotal.setText(total + " Bs.");
    }

    private void setDate() {
        tvDate.setText(format.format(date.getTime()));
    }

    public void openDatePicker() {
        // Get Current Date
        int mYear = date.get(Calendar.YEAR);
        int mMonth = date.get(Calendar.MONTH);
        int mDay = date.get(Calendar.DAY_OF_MONTH);
        //launch datepicker modal
        DatePickerDialog datePickerDialog = new DatePickerDialog(this.getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Log.e(App.TAG, "DATE SELECTED " + dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                date.set(Calendar.YEAR, year);
                date.set(Calendar.MONTH, monthOfYear);
                date.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                DateSQLite.formatDate(date.getTime());

                loadEntitys();
                setDate();
                //PUT YOUR LOGING HERE
                //UNCOMMENT THIS LINE TO CALL TIMEPICKER
                //openTimePicker();
            }
        }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }


}
