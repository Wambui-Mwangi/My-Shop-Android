package com.mwangi.myshop

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mwangi.myshop.databinding.ProductsListItemBinding
import com.squareup.picasso.Picasso

class RV_Adapter(var productList: List<Product>):RecyclerView.Adapter<ProductsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        var binding = ProductsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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
            .into(binding.ivProductOne)

    }

    override fun getItemCount(): Int {
        return productList.size
    }

}

class ProductsViewHolder(var binding: ProductsListItemBinding): RecyclerView.ViewHolder(binding.root)