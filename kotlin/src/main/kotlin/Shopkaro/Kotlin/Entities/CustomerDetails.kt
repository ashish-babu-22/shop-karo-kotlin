package Shopkaro.Kotlin.Entities

import jakarta.persistence.*

@Entity
@Table(name = "customer_details")
data class CustomerDetails(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var customerId : Int,

    @Column(name = "name")
    var name : String,

    @Column(name = "mail")
    var mail : String,

    @Column(name = "location")
    var location : String,

    @Column(name = "contact")
    var contact : String,

    @Column(name = "password")
    var password : String,

    @OneToOne
    @JoinColumn(name = "cart_id")
    var cartDetails: CartDetails
) {
}