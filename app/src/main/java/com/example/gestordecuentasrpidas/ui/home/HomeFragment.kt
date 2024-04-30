package com.example.gestordecuentasrpidas.ui.home

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gestordecuentasrpidas.R
import com.example.gestordecuentasrpidas.ui.product.Product
import com.example.gestordecuentasrpidas.ui.product.ProductAdapter
import com.example.gestordecuentasrpidas.ui.product.ProductRepository

class HomeFragment : Fragment(), CuentaAdapter.OnItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private var mesas = CuentaRepository.getMesa();

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        recyclerView = view.findViewById(R.id.homeRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val adapter = CuentaAdapter(mesas, this)
        recyclerView.adapter = adapter

        return view
    }

    override fun onItemClick(mesa: Mesa) {
        mostrarModalProductos(mesa)
    }

    private fun mostrarModalProductos(mesa: Mesa) {
        val builder = AlertDialog.Builder(context)
        val view = LayoutInflater.from(context).inflate(R.layout.modal_productos, null)
        val recyclerViewProductos = view.findViewById<RecyclerView>(R.id.recyclerViewProductos)

        val productos = ProductRepository.getProducts()
        val adapterProductos = ProductAdapter(productos, object : ProductAdapter.OnItemClickListener {
            override fun onItemClick(producto: Product) {
                agregarProductoAMesa(mesa, producto)
                /*actualizarTotalCuenta(mesa)
                actualizarVistaMesa(mesa)
                dismissModal()*/
            }
        })
        recyclerViewProductos.layoutManager = LinearLayoutManager(context)
        recyclerViewProductos.adapter = adapterProductos

        builder.setView(view)
            .setPositiveButton("Aceptar") { dialog, _ ->
                // Reset product counts to 0 here
                val adapter = recyclerViewProductos.adapter as ProductAdapter
                adapter.productList.forEach { product -> product.count = 0 }
                adapter.notifyDataSetChanged()
                dialog.dismiss()
            }
            .setNegativeButton("Cancelar") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

    private fun agregarProductoAMesa(mesa: Mesa, producto: Product) {
        val cuentaActualizada = mesa.cuenta.copy(
            productos = mesa.cuenta.productos?.toMutableList()?.apply { add(producto) },
            total = mesa.cuenta.total + producto.price
        )
        val mesaActualizada = mesa.copy(cuenta = cuentaActualizada)
        mesa.cuenta = cuentaActualizada;
        mesas = actualizarMesasEnLista(mesas, mesaActualizada)
        actualizarAdapter(mesas)
    }

    private fun actualizarMesasEnLista(mesas: List<Mesa>, mesaActualizada: Mesa): List<Mesa> {
        return mesas.map { mesa ->
            if (mesa.numero == mesaActualizada.numero) {
                mesaActualizada
            } else {
                mesa
            }
        }
    }

    private fun actualizarAdapter(mesas: List<Mesa>) {
        val adapter = recyclerView.adapter as CuentaAdapter
        adapter.updateMesas(mesas)
    }
}