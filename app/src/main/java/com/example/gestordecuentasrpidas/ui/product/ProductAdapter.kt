package com.example.gestordecuentasrpidas.ui.product

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gestordecuentasrpidas.R

class ProductAdapter(public val productList: List<Product>, private val onItemClickListener: OnItemClickListener) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private var productoSeleccionado: Product? = null
    interface OnItemClickListener {
        fun onItemClick(producto: Product)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.nameTextView.text = product.name
        holder.descriptionTextView.text = product.description
        holder.priceTextView.text = product.price.toString()
        holder.count.text = product.count.toString()

        val resourceId = holder.itemView.context.resources.getIdentifier(product.imagePath, "drawable",
            holder.itemView.context.packageName)
        Glide.with(holder.itemView)
            .load(resourceId)
            .into(holder.imageView)

        holder.itemView.setOnClickListener {
            productoSeleccionado = product
            product.count++
            notifyItemChanged(productoSeleccionado?.let { productList.indexOf(it) } ?: position)
            onItemClickListener.onItemClick(product)
        }
        val colorFondo = if (product == productoSeleccionado) {
            holder.itemView.context.getColor(R.color.teal_200)
        } else {
            holder.itemView.context.getColor(R.color.white)
        }
        holder.nameTextView.setBackgroundColor(colorFondo)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.productNameTextView)
        val priceTextView: TextView = itemView.findViewById(R.id.productPriceTextView)
        val descriptionTextView: TextView = itemView.findViewById(R.id.productDescriptionTextView)
        val imageView: ImageView = itemView.findViewById(R.id.productImageView)
        val count: TextView = itemView.findViewById(R.id.productoCantidadTextView)
    }
}
