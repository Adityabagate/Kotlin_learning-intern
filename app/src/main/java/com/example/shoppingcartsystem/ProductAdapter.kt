package com.example.shoppingcartsystem

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(private val productList: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val productName: TextView = itemView.findViewById(R.id.tvProductName)
        val productDescription: TextView = itemView.findViewById(R.id.tvDescription)
        val productPrice: TextView = itemView.findViewById(R.id.tvPrice)
        val btnAdd: Button = itemView.findViewById(R.id.btnAddCart)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)

        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        val product = productList[position]

        holder.productName.text = product.name
        holder.productDescription.text = product.description
        holder.productPrice.text = "₹${product.price}"

        holder.btnAdd.setOnClickListener {

            MainActivity.cartList.add(product)

            Toast.makeText(
                holder.itemView.context,
                "${product.name} Added Successfully\nCart Items : ${MainActivity.cartList.size}",
                Toast.LENGTH_SHORT
            ).show()

        }
    }

    override fun getItemCount(): Int {

        return productList.size

    }

}