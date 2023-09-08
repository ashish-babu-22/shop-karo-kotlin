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
    lateinit var productRepo: ProductRepo


    override fun showCartItems(id: Int?): List<ProductDetails?>? {
        val temp: Optional<CartDetails> = id?.let { cartRepo.findById(it) } ?:throw UserNotFoundException("User Not Found with ID =$id")

        return temp.get().cartItems
    }

    override fun selectProductById(id: Int?): ProductDetails {
        val res: Optional<ProductDetails?> = id?.let { productRepo.findById(it) } ?:throw ProductNotFoundException("Enter a valid Product ID")
        if(res.isEmpty)throw ProductNotFoundException("Product not found with id $id")
        return res.get()
    }


    override fun deleteCartItemByProductId(cartId: Int?, prodId: Int?) : String {
        prodId?.let {
            if (cartId != null) {
                productRepo.deleteProductInCartById(cartId, it)
            }
        }?:throw ProductNotFoundException("Item with - $prodId is not found in your cart")
        return "Item with Product id $prodId has been deleted successfully"
    }

    override fun addToCart(cartId: Int, prodId: Int?): ProductDetails {
        val tempProd: Optional<ProductDetails> = prodId?.let { productRepo.findById(it) }?:throw ProductNotFoundException("Product with id - $prodId is not found ")
        val prod = tempProd.get()
        val tempCart = cartRepo.findById(cartId)
        val cart = tempCart.get()
        cart.add(prod)
        cartRepo.save(cart)
        return prod
    }



}