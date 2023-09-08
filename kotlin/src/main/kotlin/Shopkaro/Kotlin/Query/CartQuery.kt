package Shopkaro.Kotlin.Query

import Shopkaro.Kotlin.Entities.ProductDetails
import Shopkaro.Kotlin.Service.CartService
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CartQuery : GraphQLQueryResolver{
    @Autowired
    lateinit var cartService: CartService
    fun showCartItems(id: Int): List<ProductDetails?>?{
        return cartService.showCartItems(id)
    }
    fun selectProductById(id: Int?): ProductDetails?{
        return cartService.selectProductById(id)
    }
}