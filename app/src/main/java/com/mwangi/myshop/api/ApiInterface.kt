package com.mwangi.myshop.api

import com.mwangi.myshop.model.Product
import com.mwangi.myshop.model.ProductsResponse
//import retrofit2.Call
import retrofit2.Response
//import retrofit2.http.Body
import retrofit2.http.GET
//import retrofit2.http.Path

//import retrofit2.http.POST
import retrofit2.http.Path

interface ApiInterface {
    @GET("/product")
    suspend fun getProducts(): Response<ProductsResponse>

    @GET("/product/{id}")
    suspend fun getProductById(@Path("id")productID:Int): Response<Product>
//
//    @POST("/product")
//    fun postProduct(@Body product: Product): Call<Product>
}

