package Shopkaro.Kotlin.Repositories
import Shopkaro.Kotlin.Entities.CartDetails
import org.springframework.data.jpa.repository.JpaRepository

interface CartRepo : JpaRepository<CartDetails,Int> {
}