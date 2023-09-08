package Shopkaro.Kotlin.Entities

import jakarta.persistence.*
import java.lang.Exception


@Entity
@Table(name = "cart_details")
class CartDetails(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    var cartId : Int,

    @Column(name = "total_price")
    var totalPrice : Int,

    @ManyToMany
    @JoinTable(
        name ="cart_product",
        joinColumns = [JoinColumn(name = "cart_id")],
        inverseJoinColumns = [JoinColumn(name = "product_id")]
    )
    var cartItems : MutableList<ProductDetails>?
) {
    constructor(cartId:Int) : this(cartId, 0, null) {
        this.cartId=cartId
    }


    fun add(item : ProductDetails?){
        if(cartItems == null){
            cartItems = mutableListOf()
        }
        if(item != null) {
            cartItems?.add(item)?:throw Exception("Item not found")
        }
    }
}