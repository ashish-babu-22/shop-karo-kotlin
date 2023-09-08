package Shopkaro.Kotlin.Service

import Shopkaro.Kotlin.Entities.ReviewDetails

interface ReviewService {

    fun displayReviews(prod_id: Int): List<ReviewDetails?>?

    fun addReview(cartId: Int, prodId: Int, reviewsDetails: ReviewDetails?): List<ReviewDetails?>?

}