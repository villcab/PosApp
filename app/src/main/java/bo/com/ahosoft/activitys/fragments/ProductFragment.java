package bo.com.ahosoft.activitys.fragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import bo.com.ahosoft.R;
import bo.com.ahosoft.adapters.ProductAdapter;
import bo.com.ahosoft.datas.DProduct;
import bo.com.ahosoft.entitys.inventory.Product;
import bo.com.ahosoft.utils.App;
import bo.com.ahosoft.utils.MyHttpUtils;
import bo.com.ahosoft.utils.reflextion.Action;

public class ProductFragment extends Fragment {

    private View view;

    public static final String ARG_SECTION_TITLE = "section_number";

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private List<Product> entitys;

    public static ProductFragment newInstance(String sectionTitle) {
        ProductFragment fragment = new ProductFragment();
        Bundle args = new Bundle();
        args.putString(ARG_SECTION_TITLE, sectionTitle);
        fragment.setArguments(args);
        return fragment;
    }

    public ProductFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_product, container, false);

        recycler = (RecyclerView) view.findViewById(R.id.recycler_product);
        recycler.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(view.getContext());
        recycler.setLayoutManager(layoutManager);

        FloatingActionButton btnDownload = (FloatingActionButton) view.findViewById(R.id.btnDownload);
        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadProductServices();
            }
        });

        return view;
    }

    public void loadEntitys() {
        DProduct data;
        try {
            data = new DProduct(view.getContext(), Product.class);
            entitys = data.listAll();

        } catch (Exception e) {
            Log.e(App.TAG, "Error al cargar las entidades", e);
        }
        adapter = new ProductAdapter(entitys);
        recycler.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        loadEntitys();
        super.onResume();
    }

    public void loadProductServices() {
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    MyHttpUtils http = new MyHttpUtils("http://192.168.1.13:8980/ahosoft-erp/rest/product/listByDate");
                    String resp = http.sendGet();
                    JSONArray array = new JSONArray(resp);
                    DProduct data = new DProduct(view.getContext(), Product.class);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject o = new JSONObject(array.get(i).toString());
                        Product entity = new Product();
                        entity.setId_product(o.getLong("id"));
                        entity.setName(o.getString("name"));
                        entity.setGeneric_name(o.getString("generic_name"));
                        entity.setAction(Action.INSERT);
                        data.save(entity);
                        Log.e(App.TAG, "Registro guardado: " + entity);
                    }

                } catch (Exception e) {
                    Log.e(App.TAG, "Error al cargar los products", e);
                }
            }
        };
        t.start();
        loadEntitys();
    }

}
