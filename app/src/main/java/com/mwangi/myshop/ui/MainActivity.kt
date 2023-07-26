package com.mwangi.myshop.ui

//import android.net.DnsResolver.Callback
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.mwangi.myshop.model.Product
import com.mwangi.myshop.model.ProductsResponse
import com.mwangi.myshop.api.ApiClient
import com.mwangi.myshop.api.ApiInterface
import com.mwangi.myshop.databinding.ActivityMainBinding
import com.mwangi.myshop.viewmodel.ProductsViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val productsViewModel: ProductsViewModel by viewModels()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        productsViewModel.fetchProducts()

        productsViewModel.errLiveData.observe(this, Observer { err->
            Toast.makeText(baseContext, err, Toast.LENGTH_LONG).show()
        })

        productsViewModel.productsLiveData.observe(this, Observer { productsList->
            binding.rvProducts.layoutManager = GridLayoutManager(this@MainActivity,
                2)
            binding.rvProducts.adapter = RV_Adapter(productsList, this)
        })
    }

}