package Shopkaro.Kotlin.Security.UserEntity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "users")

data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    val id : Int,
    @Column(name = "username")
    var mail : String,
    @Column(name = "password")
    var pass : String,
    @Column(name = "token")
    var token :String
) {

    constructor(mail : String,pass :String,token: String) : this(0,mail,pass,token){
        this.mail = mail
        this.pass=pass
        this.token=token
    }
}