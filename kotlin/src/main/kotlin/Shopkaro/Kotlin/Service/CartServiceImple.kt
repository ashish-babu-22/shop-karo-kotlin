package Shopkaro.Kotlin.Service

import Shopkaro.Kotlin.Entities.CartDetails
import Shopkaro.Kotlin.Entities.ProductDetails
import Shopkaro.Kotlin.ExceptionHandler.ProductNotFoundException
import Shopkaro.Kotlin.ExceptionHandler.UserNotFoundException
import Shopkaro.Kotlin.Repositories.CartRepo
import Shopkaro.Kotlin.Repositories.ProductRepo
import org.springframework.beans.factory.annotation.Autowired
import java.util.*

class CartServiceImple : CartService {

    @Autowired
    lateinit var cartRepo : CartRepo

    @Autowired
    lateinit var productsDAO : ProductRepo
    override fun showCartItems(id: Int): List<ProductDetails?>? {
        val temp: Optional<CartDetails> = cartRepo.findById(id)?:throw UserNotFoundException("User Not Found with ID =$id")

        return temp.get().cartItems
    }

    override fun selectProductById(id: Int): ProductDetails? {
        val res: Optional<ProductDetails> = productsDAO.findById(id)?:throw ProductNotFoundException("Enter a valid Product ID - $id")
        return res.get()
    }

    override fun deleteCartItemByProductId(cart_id: Int, prod_id: Int) {
        productsDAO.deleteProductInCartById(cart_id, prod_id)
    }

    override fun addToCart(cart_id: Int, prod_id: Int): ProductDetails? {
        val tempProd: Optional<ProductDetails> = productsDAO.findById(prod_id)
        val prod = tempProd.get()
        val tempCart = cartRepo.findById(cart_id)
        val cart = tempCart.get()
        cart.add(prod)
        cartRepo.save(cart)
        return prod
    }



}