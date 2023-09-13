package Shopkaro.Kotlin.Security.UserEntity

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepo : JpaRepository<User,Int> {
    fun findByUsername(username : String) : User?
    fun findTokenByUsernameAndPassword(username: String,password : String):String
    fun existByToken(token : String):Boolean
}