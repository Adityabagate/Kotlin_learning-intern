package com.example.shoppingcartsystem

import android.content.Intent
import android.widget.Button
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    companion object {
        val cartList = mutableListOf<Product>()
    }
    private lateinit var btnViewCart: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rvProducts)
        btnViewCart = findViewById(R.id.btnViewCart)

        val productList = listOf(
            Product("Laptop", "High Performance Laptop", 55000),
            Product("Mouse", "Wireless Mouse", 500),
            Product("Keyboard", "Mechanical Keyboard", 1500),
            Product("Monitor", "24 Inch Monitor", 12000),
            Product("Headphones", "Bluetooth Headphones", 2500)
        )

        adapter = ProductAdapter(productList)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        btnViewCart.setOnClickListener {

            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)

        }
    }
}