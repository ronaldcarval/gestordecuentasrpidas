package com.example.gestordecuentasrpidas.ui.ordenes

import com.example.gestordecuentasrpidas.ui.product.Product

data class Ordenes(
    var tableNumber: Int,
    var waiterName: String,
    var date: String,
    var products: MutableList<Product>
)