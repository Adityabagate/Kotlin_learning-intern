package com.example.shoppingcartsystem

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CartActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var tvTotal: TextView
    private lateinit var btnBack: Button
    private lateinit var adapter: CartAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        recyclerView = findViewById(R.id.rvCart)
        tvTotal = findViewById(R.id.tvTotal)
        btnBack = findViewById(R.id.btnBack)

        adapter = CartAdapter(MainActivity.cartList)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        var total = 0

        for (product in MainActivity.cartList) {
            total += product.price
        }

        tvTotal.text = "Total : ₹$total"

        btnBack.setOnClickListener {
            finish()
        }
    }
}