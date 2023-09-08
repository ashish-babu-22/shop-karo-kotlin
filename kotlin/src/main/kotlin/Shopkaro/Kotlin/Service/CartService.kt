package Shopkaro.Kotlin.Service

import Shopkaro.Kotlin.Entities.CustomerDetails
import Shopkaro.Kotlin.Entities.OrderDetails
import Shopkaro.Kotlin.Entities.ProductDetails

interface CartService {



    fun showCartItems(id: Int): List<ProductDetails?>?
    fun selectProductById(id: Int): ProductDetails?
    fun deleteCartItemByProductId(cart_id: Int, prod_id: Int)

    fun addToCart(cart_id: Int, prod_id: Int): ProductDetails?




}