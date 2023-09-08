package Shopkaro.Kotlin.Query

import Shopkaro.Kotlin.Entities.ReviewDetails
import Shopkaro.Kotlin.Service.ReviewService
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ReviewQuery : GraphQLQueryResolver{

    @Autowired
    lateinit var reviewService: ReviewService
    fun displayReviews(prodId: Int?): List<ReviewDetails?>?{
        return reviewService.displayReviews(prodId)
    }

}