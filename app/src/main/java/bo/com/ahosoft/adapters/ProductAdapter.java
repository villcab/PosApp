package bo.com.ahosoft.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import bo.com.ahosoft.R;
import bo.com.ahosoft.entitys.inventory.Product;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.EntityViewHolder> {
    private List<Product> items;

    public ProductAdapter(List<Product> items) {
        this.items = items;
    }

    @Override
    public EntityViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_product, viewGroup, false);
        return new EntityViewHolder(v);
    }

    @Override
    public void onBindViewHolder(EntityViewHolder entityViewHolder, int i) {
        entityViewHolder.name.setText(items.get(i).getName());
//        entityViewHolder.descripcion.setText(items.get(i).getDescripcion());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class EntityViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public TextView name;
        //public TextView descripcion;

        public EntityViewHolder(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.description);
            //descripcion = (TextView) v.findViewById(R.id.descripcion);
        }
    }
}
