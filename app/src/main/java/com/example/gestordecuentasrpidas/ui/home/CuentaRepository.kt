package com.example.gestordecuentasrpidas.ui.home
import com.example.gestordecuentasrpidas.ui.product.Product

object CuentaRepository {
    private val cuentaList = mutableListOf<Mesa>()

    init {
        val product1 = Product("Coctel Bienbenida", "Coctel Bienbenida", 0.0, "aguila")

        cuentaList.add(Mesa(1, "Juan Martinez", Cuenta(0.0, listOf(product1))))
        cuentaList.add(Mesa(2, "Carlos Perez", Cuenta(0.0, listOf(product1))))
        cuentaList.add(Mesa(3, "Camila Paez", Cuenta(0.0, listOf(product1))))
    }

    fun getMesa(): List<Mesa> {
        return cuentaList
    }

    fun addMesa(mesa: Mesa) {
        cuentaList.add(mesa)
    }
}

data class Mesa(
    val numero: Int,
    val mesero: String,
    var cuenta: Cuenta
)

data class Cuenta(
    val total: Double,
    val productos: List<Product>?
)