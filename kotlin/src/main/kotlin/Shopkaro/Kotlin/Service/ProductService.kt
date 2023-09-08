package Shopkaro.Kotlin.Service

import Shopkaro.Kotlin.Entities.CustomerDetails
import Shopkaro.Kotlin.Entities.ProductDetails

interface ProductService {

    fun showProducts(id: Int): List<ProductDetails?>?

    fun deleteProductById(id: Int)


    fun addProduct(productDetails: ProductDetails?): ProductDetails?

    fun updateProduct(productDetails: ProductDetails?): ProductDetails?

    fun updateDetails(customerDetails: CustomerDetails?)

    fun vewProductById(prodId: Int): ProductDetails?

}