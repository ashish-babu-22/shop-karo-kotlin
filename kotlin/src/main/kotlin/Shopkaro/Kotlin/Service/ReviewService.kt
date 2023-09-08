package Shopkaro.Kotlin.Service

import Shopkaro.Kotlin.Entities.ReviewDetails

interface ReviewService {

    fun displayReviews(prodId: Int?): List<ReviewDetails?>?

    fun addReview(cartId: Int, prodId: Int, review: ReviewDetails?): List<ReviewDetails?>?

}