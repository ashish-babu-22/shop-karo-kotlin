package Shopkaro.Kotlin.Service

import Shopkaro.Kotlin.Entities.OrderDetails

interface OrderQuery {
    fun checkOut(cart_id: Int): OrderDetails?
}