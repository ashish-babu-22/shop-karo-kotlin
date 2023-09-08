package Shopkaro.Kotlin.Mutation

import Shopkaro.Kotlin.Entities.OrderDetails
import Shopkaro.Kotlin.Service.OrderService
import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class OrderMutation : GraphQLMutationResolver{

    @Autowired
    lateinit var orderService: OrderService
    fun checkOut(cartId: Int): OrderDetails?{
        return orderService.checkOut(cartId)
    }
}