package Shopkaro.Kotlin.Security.Controller

import Shopkaro.Kotlin.Entities.CustomerDetails
import Shopkaro.Kotlin.Security.UserEntity.User
import Shopkaro.Kotlin.Security.UserEntity.UserRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.RememberMeAuthenticationProvider
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.authentication.RememberMeServices
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@Suppress("NAME_SHADOWING")
@RestController
@RequestMapping("/shopkaro/")
class UserController {

    @Autowired
    lateinit var userRepo : UserRepo

    lateinit var authenticationManager : AuthenticationManager
    lateinit var rememberMeServices : RememberMeServices
    @PostMapping("/signup")
    fun signup(@RequestBody customerDetails: CustomerDetails) : ResponseEntity<Any> {
        val existingUser = userRepo.findByUsername(customerDetails.mail)
        if (existingUser != null) {
            return ResponseEntity.badRequest().body("Username Exist")
        }

        val hashedPassword = BCryptPasswordEncoder().encode(customerDetails.password)
        val authenticationToken = UsernamePasswordAuthenticationToken(customerDetails.mail,customerDetails.password)
        val newUser = User(customerDetails.mail,customerDetails.password,authenticationToken.toString())
        userRepo.save(newUser)

        return ResponseEntity.ok("User Created")

    }


    @PostMapping("/login")
    fun loginSuccess(@RequestBody creds : CustomerDetails, request : HttpServletRequest, response : HttpServletResponse, authentication: Authentication){
        val sessionId = userRepo.findTokenByUsernameAndPassword(creds.mail,creds.password)
        val authentication = authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(creds.mail,creds.password)
        )
        val cookie = Cookie("SESSION_ID",sessionId)
        cookie.maxAge = 30000
        cookie.path="/"
        response.addCookie(cookie)
    }

    @PostMapping("/logout")
    fun logout(request: HttpServletRequest,response: HttpServletResponse){
        request.session.invalidate()
    }


}

