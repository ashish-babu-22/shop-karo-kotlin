package Shopkaro.Kotlin.Entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany
import jakarta.persistence.Table


@Entity
@Table(name = "product_details")
class ProductDetails(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    var productId : Int,

    @Column(name = "quantity")
    var quantity : String,

    @Column(name = "price")
    var price : Int,

    @OneToMany
    @JoinColumn(name = "product_id")
    var reviews : MutableList<ReviewDetails>?
) {

    fun addReview(review : ReviewDetails){
        if(reviews == null){
            reviews = mutableListOf();
        }
        reviews?.add(review)?:throw Exception("Enter review")
    }


}