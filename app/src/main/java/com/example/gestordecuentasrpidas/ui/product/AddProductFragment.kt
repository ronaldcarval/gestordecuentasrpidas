package com.example.gestordecuentasrpidas.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.gestordecuentasrpidas.databinding.FragmentAddProductBinding
import com.example.gestordecuentasrpidas.ui.product.Product

class AddProductFragment : Fragment() {

    private var _binding: FragmentAddProductBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener {
            saveProduct()
        }
    }

    private fun saveProduct() {
        val name = binding.editTextName.text.toString()
        val description = binding.editTextDescription.text.toString()
        val price = binding.editTextPrice.text.toString().toDoubleOrNull()
        val imagePath = binding.editTextImagePath.text.toString()

        if (name.isEmpty() || description.isEmpty() || price == null || imagePath.isEmpty()) {
            Toast.makeText(context, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            return
        }
        val newProduct = Product(name, description, price, imagePath)
        Toast.makeText(context, "Product added: $name", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
