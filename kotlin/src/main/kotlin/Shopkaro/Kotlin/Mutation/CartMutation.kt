package Shopkaro.Kotlin.Mutation

import Shopkaro.Kotlin.Entities.ProductDetails
import Shopkaro.Kotlin.Repositories.CartRepo
import Shopkaro.Kotlin.Service.CartService
import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


@Component
class CartMutation : GraphQLMutationResolver {

    @Autowired
    lateinit var cartService: CartService
    fun deleteCartItemByProductId(cartId: Int, prodId: Int?) : String{
        return cartService.deleteCartItemByProductId(cartId,prodId)
    }

    fun addToCart(cartId: Int, prodId: Int?): ProductDetails?{
        return cartService.addToCart(cartId,prodId)
    }
}