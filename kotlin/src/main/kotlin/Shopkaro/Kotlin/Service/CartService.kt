package Shopkaro.Kotlin.Service

import Shopkaro.Kotlin.Entities.CustomerDetails
import Shopkaro.Kotlin.Entities.OrderDetails
import Shopkaro.Kotlin.Entities.ProductDetails

interface CartService {



    fun showCartItems(id: Int?): List<ProductDetails?>?
    fun selectProductById(id: Int?): ProductDetails?
    fun deleteCartItemByProductId(cartId: Int?, prodId: Int?):String

    fun addToCart(cartId: Int, prodId: Int?): ProductDetails?




}