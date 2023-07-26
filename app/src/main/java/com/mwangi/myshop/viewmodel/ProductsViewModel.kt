package com.mwangi.myshop.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mwangi.myshop.model.Product
import com.mwangi.myshop.repository.ProductsRepository
import kotlinx.coroutines.launch

class ProductsViewModel: ViewModel() {
    val productsRepo = ProductsRepository()
    val productsLiveData = MutableLiveData<List<Product>>()
    val errLiveData = MutableLiveData<String>()

    fun fetchProducts(){
        viewModelScope.launch {
            val response = productsRepo.getProducts()
            if (response.isSuccessful){
                productsLiveData.postValue(response.body()?.products)
            }else{
                errLiveData.postValue(response.errorBody()?.string())
            }
        }
    }


}