package Shopkaro.Kotlin.Service

import Shopkaro.Kotlin.Entities.CartDetails
import Shopkaro.Kotlin.Entities.CustomerDetails
import Shopkaro.Kotlin.Entities.OrderDetails
import Shopkaro.Kotlin.Entities.ProductDetails
import Shopkaro.Kotlin.ExceptionHandler.UserNotFoundException
import Shopkaro.Kotlin.Repositories.CartRepo
import Shopkaro.Kotlin.Repositories.CustomerRepo
import Shopkaro.Kotlin.Repositories.OrderRepo
import Shopkaro.Kotlin.Repositories.ProductRepo
import org.springframework.beans.factory.annotation.Autowired
import java.time.LocalDate
import java.util.*


class OrderServiceImple : OrderService{


    @Autowired
    lateinit var cartRepo : CartRepo
    @Autowired
    lateinit var customerRepo : CustomerRepo
    @Autowired
    lateinit var productsRepo : ProductRepo
 @Autowired
    lateinit var orderRepo : OrderRepo

    override fun checkOut(cartId: Int): OrderDetails {
        val byId: Optional<CartDetails?> = cartRepo.findById(cartId)
        val cart =  byId.get()

        val cartItemDetails: MutableList<ProductDetails>? = cart.cartItems
        val byId1: Optional<CustomerDetails> = customerRepo.findById(cartId)
        val cus =  byId1.get()

        val name: String = cus.name
        val location: String = cus.location
        val dateOfOrder = LocalDate.now().toString()
        val dateOfDelivery = LocalDate.now().plusDays(10).toString()
        val amountPayable: Int = productsRepo.totalPrice(cartId)
        cart.totalPrice = amountPayable
        val order = OrderDetails(name, location, dateOfOrder, dateOfDelivery, amountPayable)
        order.cartDetails = cart
        orderRepo.save(order)
        cartRepo.save(cart)
        return order
    }


}