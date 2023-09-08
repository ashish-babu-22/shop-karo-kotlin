package Shopkaro.Kotlin.Repositories
import Shopkaro.Kotlin.Entities.CustomerDetails
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.transaction.annotation.Transactional

interface CustomerRepo : JpaRepository<CustomerDetails,Int> {
    @Transactional
    @Modifying
    @Query(value = "insert into users (username,password,status) VALUES (:uname,:pass,1)", nativeQuery = true)
    fun addToUserDB(@Param("uname") uname: String?, @Param("pass") pass: String?)

    @Transactional
    @Modifying
    @Query(value = "insert into roles (username,role) VALUES (:uname,'ROLE_CUSTOMER')", nativeQuery = true)
    fun addToRolesDB(@Param("uname") username: String?)

    @Query("select id from CustomerDetails where mail=:mail or contact=:contact and password=:password")
    fun getCustomerIdByMailAndPass(
        @Param("mail") mail: String?,
        @Param("password") password: String?,
        @Param("contact") contact: String?
    ): Int?

}