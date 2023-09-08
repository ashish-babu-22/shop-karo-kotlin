package Shopkaro.Kotlin.Repositories
import org.springframework.data.jpa.repository.JpaRepository
import Shopkaro.Kotlin.Entities.ProductDetails
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.transaction.annotation.Transactional

interface ProductRepo : JpaRepository<ProductDetails,Int> {
    @Transactional
    @Modifying
    @Query(value = "delete from cart_product where cart_id =:cart_id and product_id=:prod_id")
    fun deleteProductInCartById(
        @Param("cart_id") cartId :Int,
        @Param("prod_id") prodId : Int
    )

    @Query(
        value = "SELECT Sum(p.price) " +
                "From Product_details p " +
                "join cart_product on p.product_id = cp.product_id" +
                "WHERE cp.cart_id = :cart_id", nativeQuery = true
    )
    fun totalPrice(
        @Param("cart_id")cartId : Int
    ) : Int
}