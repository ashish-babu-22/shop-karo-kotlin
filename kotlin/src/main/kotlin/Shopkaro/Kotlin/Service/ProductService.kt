package Shopkaro.Kotlin.Service

import Shopkaro.Kotlin.Entities.CustomerDetails
import Shopkaro.Kotlin.Entities.ProductDetails

interface ProductService {

    fun showProducts(id: Int): List<ProductDetails?>?
    fun viewProductById(prodId: Int?): ProductDetails?

    fun deleteProductById(id: Int?) : String


    fun addProduct(productDetails: ProductDetails?): ProductDetails?

    fun updateProduct(productDetails: ProductDetails?): ProductDetails?


}