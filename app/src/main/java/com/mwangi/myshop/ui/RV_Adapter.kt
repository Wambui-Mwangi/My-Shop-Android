package com.mwangi.myshop.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mwangi.myshop.databinding.ProductListItemBinding
import com.mwangi.myshop.model.Product
import com.squareup.picasso.Picasso

class RV_Adapter(var productList: List<Product>, var context:Context):RecyclerView.Adapter<ProductsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        var binding = ProductListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        var pro = productList[position]
        var binding = holder.binding
        binding.tvTitle.text = pro.title
        binding.tvDescription.text = pro.description
        binding.tvPrice.text = pro.price.toString()

        Picasso.get()
            .load(pro.thumbnail)
            .into(binding.ivProduct)

     holder.binding.cvProduct.setOnClickListener{
         val intent = Intent(context, ProductDetails::class.java)
         intent.putExtra("product", pro)
         context.startActivity(intent)

        }
    }


    override fun getItemCount(): Int {
        return productList.size
    }

}

class ProductsViewHolder(var binding: ProductListItemBinding): RecyclerView.ViewHolder(binding.root)