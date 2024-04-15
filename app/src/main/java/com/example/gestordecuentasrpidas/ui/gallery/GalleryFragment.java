package com.example.gestordecuentasrpidas.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.gestordecuentasrpidas.R;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        recyclerView = root.findViewById(R.id.productRecyclerView);
        // Configura el RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        // Configura el adaptador para el RecyclerView
        ProductAdapter adapter = new ProductAdapter(getProductList());
        recyclerView.setAdapter(adapter);
        return root;
    }

    // Método de ejemplo para obtener una lista de productos
    private List<Product> getProductList() {
        List<Product> productList = new ArrayList<>();
        // Agrega productos a la lista
        productList.add(new Product("Azucar", "Azucar manuelita x 1kg",10.0, "azucar"));
        productList.add(new Product("Arroz", "Arroz x 1kg", 15.0, "arroz"));
        productList.add(new Product("Arina", "Arina Pan x 1kg",20.0, "arina"));
        // Agrega más productos si es necesario
        return productList;
    }
}