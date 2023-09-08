package Shopkaro.Kotlin.Repositories
import org.springframework.data.jpa.repository.JpaRepository
import Shopkaro.Kotlin.Entities.OrderDetails

interface OrderRepo : JpaRepository<OrderDetails,Int> {
}