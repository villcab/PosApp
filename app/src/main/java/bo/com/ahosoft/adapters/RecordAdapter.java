package bo.com.ahosoft.adapters;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

import bo.com.ahosoft.R;
import bo.com.ahosoft.activitys.fragments.RecordFragment;
import bo.com.ahosoft.entitys.Record;
import bo.com.ahosoft.utils.App;

public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.EntityViewHolder> {

    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private List<Record> items;

    private RecordFragment fragment;

    public RecordAdapter(List<Record> items, RecordFragment fragment) {
        this.items = items;
        this.fragment = fragment;
    }

    @Override
    public EntityViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_record, viewGroup, false);
        return new EntityViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final EntityViewHolder entityViewHolder, final int i) {
        entityViewHolder.descripcion.setText(items.get(i).getDescription());
        entityViewHolder.amount.setText(items.get(i).getAmount().toString() + " Bs.");
        entityViewHolder.date.setText(format.format(items.get(i).getDate()));

        entityViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment.onItemClick(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class EntityViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public TextView descripcion;
        public TextView amount;
        public TextView date;

        public EntityViewHolder(View v) {
            super(v);
            descripcion = (TextView) v.findViewById(R.id.description);
            amount = (TextView) v.findViewById(R.id.amount);
            date = (TextView) v.findViewById(R.id.date);
        }
    }
}
