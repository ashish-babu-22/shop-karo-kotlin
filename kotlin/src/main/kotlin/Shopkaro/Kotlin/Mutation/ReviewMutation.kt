package Shopkaro.Kotlin.Mutation

import Shopkaro.Kotlin.Entities.ReviewDetails
import Shopkaro.Kotlin.Service.ReviewService
import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ReviewMutation  : GraphQLMutationResolver{

    @Autowired
    lateinit var reviewService: ReviewService
    fun addReview(cartId: Int, prodId: Int, review: ReviewDetails?): List<ReviewDetails?>?{
        return reviewService.addReview(cartId,prodId,review)
    }
}