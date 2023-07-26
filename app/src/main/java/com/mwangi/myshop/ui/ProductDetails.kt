//package com.mwangi.myshop

package com.mwangi.myshop.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mwangi.myshop.R
import com.mwangi.myshop.databinding.ActivityProductDetailsBinding
import com.mwangi.myshop.model.Product
import com.squareup.picasso.Picasso

class ProductDetails : AppCompatActivity() {
    private lateinit var binding: ActivityProductDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val product = intent.getParcelableExtra<Product>("product")
        product
            ?.let {
                binding.tvtitle.text = "${it.title}"
                binding.tvbrand.text = "Brand: ${it.brand}"
                binding.tvprice.text = "Price: ${it.price}"
                binding.tvdescription.text = "${it.description}"
                binding.tvrating.text = "Rating: ${it.rating}"
                Picasso
                    .get()
                    .load(it.thumbnail)
                    .resize(400, 300)
                    .centerCrop()
                    .into(binding.ivImage)
            }
    }
}
