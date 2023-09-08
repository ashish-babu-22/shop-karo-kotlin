package Shopkaro.Kotlin.Entities

import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

class ReviewDetails (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    var reviewId : Int,

    @Column(name = "name")
    var name : String,

    @Column(name = "comment")
    var comment : String
){
}