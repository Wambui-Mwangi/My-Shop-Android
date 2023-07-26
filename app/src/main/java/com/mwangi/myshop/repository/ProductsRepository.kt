package com.mwangi.myshop.repository

import com.mwangi.myshop.api.ApiClient
import com.mwangi.myshop.api.ApiInterface
import com.mwangi.myshop.model.ProductsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class ProductsRepository {
    val apiClient = ApiClient.buildClient(ApiInterface::class.java)

    suspend fun getProducts(): Response<ProductsResponse>{
        return withContext(Dispatchers.IO){
            apiClient.getProducts()
        }
    }
}