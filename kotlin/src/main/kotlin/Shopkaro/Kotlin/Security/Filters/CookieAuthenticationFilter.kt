package Shopkaro.Kotlin.Security.Filters

import Shopkaro.Kotlin.ExceptionHandler.GlobalExceptionalHandler
import Shopkaro.Kotlin.Security.UserEntity.UserRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.filter.OncePerRequestFilter

import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import kotlin.Exception

class CookieAuthenticationFilter : OncePerRequestFilter (){

    @Autowired
    lateinit var userRepo: UserRepo
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val sessionId = request.cookies?.firstOrNull { it.name == "SESSION_ID" }?.value?:throw Exception("Something went wrong")
        val isAuthenticated = isValidSessionId(sessionId)

        if(isAuthenticated){
            filterChain.doFilter(request,response)
        }
        else{
            throw Exception("User unAuthorized")
        }

    }

    private fun isValidSessionId(sessionId : String):Boolean{
        return userRepo.existByToken(sessionId)
    }
}