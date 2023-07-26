package com.mwangi.myshop.model

import com.mwangi.myshop.model.Product

data class ProductsResponse(
    var products: List<Product>,
    var total:Int,
    var skip:Int,
    var limit:Int

)
