package Shopkaro.Kotlin.Service

import Shopkaro.Kotlin.Repositories.*
import Shopkaro.Kotlin.Entities.*
import Shopkaro.Kotlin.ExceptionHandler.ProductNotFoundException
import Shopkaro.Kotlin.ExceptionHandler.UserNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.*

@Service
class ServiceLayer {

    @Autowired  private var productsDAO: ProductRepo? = null

        fun setProductsDAO(productsDAO: ProductRepo?) {
            this.productsDAO = productsDAO
        }

        private var customerRepo: CustomerRepo? = null
        @Autowired
        fun setCustomerDAO(customerRepo: CustomerRepo?) {
            this.customerRepo = customerRepo
        }

        private var orderDetailsDAO: OrderRepo? = null
        @Autowired
        fun setOrderDetailsDAO(orderDetailsDAO: OrderRepo?) {
            this.orderDetailsDAO = orderDetailsDAO
        }

        private var cartRepo: CartRepo? = null
        @Autowired
        fun setCartDAO(cartRepo: CartRepo?) {
            this.cartRepo = cartRepo
        }

        private var reviewRepo: ReviewRepo? = null
        fun setReviewDAO(reviewRepo: ReviewRepo?) {
            this.reviewRepo = reviewRepo
        }

    override fun showProducts(id: Int): List<ProductDetails> {

    }


        override fun deleteCartItemByProductId(cart_id: Int, prod_id: Int) {

        }

        override fun checkOut(cart_id: Int): OrderDetails {
            val byId: Optional<CartDetails> = cartRepo.findById(cart_id)
            val cart: CartDetails
            cart = if (byId.isPresent()) {
                byId.get()
            } else {
                throw UserNotFoundException("User Not Found with ID =$cart_id")
            }
            val cartItemDetails: MutableList<ProductDetails>? = cart.cartItems
            val byId1: Optional<CustomerDetails> = customerRepo.findById(cart_id)
            val cus: CustomerDetails
            cus = if (byId1.isPresent()) {
                byId1.get()
            } else {
                throw UserNotFoundException("User Not Found with ID =$cart_id")
            }
            val name: String = cus.name
            val location: String = cus.location
            val dateOfOrder = LocalDate.now().toString()
            val dateOfDelivery = LocalDate.now().plusDays(10).toString()
            val amountPayable: Int = productsDAO.totalPrice(cart_id)
            cart.setTotalPrice(amountPayable)
            val order = OrderDetails(name, location, dateOfOrder, dateOfDelivery, amountPayable)
            order.setCartDetails_inOrd(cart)
            orderDetailsDAO.save(order)
            cartRepo.save(cart)
            return order
        }

        override fun displayReviews(prod_id: Int): MutableList<ReviewDetails>? {
            val product: ProductDetails? = selectProductById(prod_id)
            if (product != null) {
                return product.reviews
            }
            else
                throw ProductNotFoundException("Error")
        }

        override fun addReview(cartId: Int, prodId: Int, review: ReviewDetails): MutableList<ReviewDetails>? {
            val byId: Optional<CustomerDetails> = customerRepo.findById(cartId)
            val cus: CustomerDetails = if (byId.isPresent()) {
                byId.get()
            } else {
                throw UserNotFoundException("User Not Found with ID =$cartId")
            }
            val name: String = cus.name
            review.setName(name)
            val byId1: Optional<ProductDetails> = productsDAO.findById(prodId)
            val prod: ProductDetails
            prod = if (byId1.isPresent()) {
                byId1.get()
            } else {
                throw ProductNotFoundException("Product Not Found with ID = $prodId")
            }
            prod.addReview(review)
            productsDAO.save(prod)
            return prod.reviews
        }


       fun addProduct(productDetails: ProductDetails): ProductDetails {

            return productsDAO.save(productDetails)
        }

        override fun updateProduct(productDetails: ProductDetails?): ProductDetails {
            return productsDAO.save(productDetails)
        }

        override fun updateDetails(customerDetails: CustomerDetails?) {
            customerRepo.save(customerDetails)
        }

        override fun vewProductById(prodId: Int): ProductDetails {
            return productsDAO.findByProductID(prodId)
        }
    }

}