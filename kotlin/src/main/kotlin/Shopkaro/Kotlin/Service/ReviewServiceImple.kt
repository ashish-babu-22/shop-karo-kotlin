package Shopkaro.Kotlin.Service

import Shopkaro.Kotlin.Entities.CustomerDetails
import Shopkaro.Kotlin.Entities.ProductDetails
import Shopkaro.Kotlin.Entities.ReviewDetails
import Shopkaro.Kotlin.ExceptionHandler.ProductNotFoundException
import Shopkaro.Kotlin.ExceptionHandler.UserNotFoundException
import Shopkaro.Kotlin.Repositories.CustomerRepo
import Shopkaro.Kotlin.Repositories.ProductRepo
import org.springframework.beans.factory.annotation.Autowired
import java.util.*

class ReviewServiceImple : ReviewService {

    @Autowired
    lateinit var customerRepo : CustomerRepo;

    @Autowired
    lateinit var productsRepo : ProductRepo;
    override fun displayReviews(prodId: Int?): List<ReviewDetails>? {
         val product : ProductServiceImple = ProductServiceImple();
        return product.selectProductById(prodId).reviews
    }

    override fun addReview(cartId: Int, prodId: Int, review: ReviewDetails?): List<ReviewDetails>? {
        review?.let {  }?:throw UserNotFoundException("Enter some Reviews")
        val byId: Optional<CustomerDetails> = customerRepo.findById(cartId)
        val cus: CustomerDetails=byId.get()
        val name: String = cus.name
        review.name=name
        val byId1: Optional<ProductDetails> = productsRepo.findById(prodId)
        val prod = byId1.get()
        prod.addReview(review)
        productsRepo.save(prod)
        return prod.reviews
    }


}