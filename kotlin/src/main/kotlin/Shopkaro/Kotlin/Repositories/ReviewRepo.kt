package Shopkaro.Kotlin.Repositories
import org.springframework.data.jpa.repository.JpaRepository
import Shopkaro.Kotlin.Entities.ReviewDetails

interface ReviewRepo : JpaRepository<ReviewDetails,Int> {
}