package Shopkaro.Kotlin.Service

import Shopkaro.Kotlin.Entities.OrderDetails

interface OrderService {
    fun checkOut(cartId: Int): OrderDetails?
}