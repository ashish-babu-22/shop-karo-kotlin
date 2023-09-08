package Shopkaro.Kotlin.Entities

import jakarta.persistence.CascadeType
import jakarta.persistence.CascadeType.*
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Entity
@Table(name = "order_details")
class OrderDetails(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    var orderId : Int,

    @Column(name = "name")
    var name : String,

    @Column(name = "location")
    var location : String,

    @Column(name = "doo")
    var DoO : String,

    @Column(name = "dod")
    var DoD : String,

    @Column(name = "amount_payable")
    var amountPayable :  Int,

    @OneToOne
    @JoinColumn(name = "cart_id")
    var cartDetails: CartDetails
) {
}