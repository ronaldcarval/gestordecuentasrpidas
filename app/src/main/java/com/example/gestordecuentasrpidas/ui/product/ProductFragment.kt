package com.example.gestordecuentasrpidas.ui.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gestordecuentasrpidas.R
import com.example.gestordecuentasrpidas.ui.home.CuentaAdapter
import com.example.gestordecuentasrpidas.ui.home.Mesa

class ProductFragment : Fragment(), CuentaAdapter.OnItemClickListener {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)
        recyclerView = root.findViewById(R.id.productRecyclerView)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        recyclerView.adapter = ProductAdapter(ProductRepository.getProducts(), object : ProductAdapter.OnItemClickListener {
            override fun onItemClick(producto: Product) {

            }
        })

        return root
    }

    override fun onItemClick(mesa: Mesa) {
        TODO("Not yet implemented")
    }
}
