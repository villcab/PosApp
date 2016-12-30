package bo.com.ahosoft.activitys.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import bo.com.ahosoft.R;
import bo.com.ahosoft.adapters.CategoryAdapter;
import bo.com.ahosoft.datas.DCategory;
import bo.com.ahosoft.entitys.Category;
import bo.com.ahosoft.utils.App;

public class CategoryFragment extends Fragment {

    private View view;

    public static final String ARG_SECTION_TITLE = "section_number";

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private List<bo.com.ahosoft.entitys.Category> entitys;

    public static CategoryFragment newInstance(String sectionTitle) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_SECTION_TITLE, sectionTitle);
        fragment.setArguments(args);
        Log.e(App.TAG, "NEWINSTANCE");
        return fragment;
    }

    public CategoryFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_category, container, false);

        recycler = (RecyclerView) view.findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(view.getContext());
        recycler.setLayoutManager(layoutManager);

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
            DCategory data = new DCategory(view.getContext(), Category.class);
            entitys = data.listAll();

        } catch (Exception e) {
            Log.e(App.TAG, "Error al cargar la entidades: " + e.toString());
        }
        adapter = new CategoryAdapter(entitys);
        recycler.setAdapter(adapter);
    }

}
