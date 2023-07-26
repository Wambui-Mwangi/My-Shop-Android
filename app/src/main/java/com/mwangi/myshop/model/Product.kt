package com.mwangi.myshop.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.security.cert.CertificateNotYetValidException

@Parcelize
data class Product(
    var id: Int,
    var title: String,
    var description: String,
    var price: Double,
    var rating: Double,
    var stock: Int,
    var brand: String,
    var category: String,
    var thumbnail: String
):Parcelable
