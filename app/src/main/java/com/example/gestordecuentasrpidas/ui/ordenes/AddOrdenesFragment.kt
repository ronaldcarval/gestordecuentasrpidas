package com.example.gestordecuentasrpidas.ui.ordenes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.gestordecuentasrpidas.databinding.FragmentAddOrdenesBinding
import com.example.gestordecuentasrpidas.R
import com.example.gestordecuentasrpidas.ui.product.Product
import com.example.gestordecuentasrpidas.ui.product.ProductRepository

class AddOrdenesFragment : Fragment() {
    private var _binding: FragmentAddOrdenesBinding? = null
    private val binding get() = _binding!!
    private lateinit var spinner: Spinner
    private val productsList = mutableListOf<Product>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddOrdenesBinding.inflate(inflater, container, false)
        spinner = binding.productsSpinner  // Acceder al spinner a través del binding

        setupSpinner()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.submitButton.setOnClickListener {
            saveOrder()
        }
    }

    private fun setupSpinner() {
        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            ProductRepository.getProducts().map { it.name }
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                // Aquí puedes manejar lo que sucede cuando se selecciona un ítem
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Manejar la no selección
            }
        }
    }

    private fun saveOrder() {
        val tableNumber = binding.tableNumberEditText.text.toString().toIntOrNull() ?: return
        val waiterName = binding.waiterNameEditText.text.toString()
        val date = binding.dateEditText.text.toString()

        val order = Ordenes(
            tableNumber = tableNumber,
            waiterName = waiterName,
            date = date,
            products = productsList
        )

        saveOrderToDatabase(order)
    }

    private fun saveOrderToDatabase(order: Ordenes) {
        println("Guardando pedido: $order")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}