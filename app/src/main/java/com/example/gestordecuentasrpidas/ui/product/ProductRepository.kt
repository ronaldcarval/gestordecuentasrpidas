package com.example.gestordecuentasrpidas.ui.product

object ProductRepository {
    private val productList = mutableListOf<Product>()

    init {
        // Inicializar con algunos productos predeterminados
        productList.add(Product("Cerveza Aguila", "Cerveza Aguila 330 ml", 10.0, "aguila"))
        productList.add(Product("Ron Caldas", "750 ml", 15.0, "caldas"))
        productList.add(Product("Aguardiente Nectar", "100ml", 20.0, "nectar"))
    }

    fun getProducts(): List<Product> {
        return productList
    }

    fun addProduct(product: Product) {
        productList.add(product)
    }
}
