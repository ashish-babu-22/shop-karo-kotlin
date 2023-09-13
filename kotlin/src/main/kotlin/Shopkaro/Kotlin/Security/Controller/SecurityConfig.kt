package Shopkaro.Kotlin.Security.Controller

import Shopkaro.Kotlin.ExceptionHandler.UserNotFoundException
import Shopkaro.Kotlin.Security.UserEntity.UserRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.RememberMeAuthenticationProvider
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.authentication.RememberMeServices
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices
import java.lang.Exception


@Suppress("DEPRECATION")
@Configuration
@EnableWebSecurity
class SecurityConfig  : WebSecurityConfigurerAdapter() {

    @Autowired lateinit var userRepo: UserRepo


    @Autowired
    lateinit var rememberMeServices: RememberMeServices

    @Autowired
    lateinit var rememberMeAuthenticationProvider: RememberMeAuthenticationProvider

    @Bean
    fun rememberMeTokenRepository(): InMemoryTokenRepositoryImpl {
        return InMemoryTokenRepositoryImpl()
    }

    override fun configure(http: HttpSecurity) {
        http
            .authorizeRequests()
            .antMatchers("/shopkaro/signup").permitAll()
            .and()
            .formLogin()
            .loginPage("/shopkaro/login").permitAll()
            .and()
            .rememberMe()
            .rememberMeServices(rememberMeServices)
            .key("mySecretKey") // Change this key to something secure
            .and()
            .logout()
            .logoutSuccessUrl("/login")
            .and()
    }

    @Bean
    fun rememberMeServices(): RememberMeServices {
        val rememberMeServices = TokenBasedRememberMeServices("mySecretKey", userDetailsService())
        rememberMeServices.setTokenValiditySeconds(3600) // Set the token validity period
        rememberMeServices.setParameter("remember-me") // Change the parameter name as needed
        return rememberMeServices
    }

    @Bean
    fun rememberMeAuthenticationProvider(): RememberMeAuthenticationProvider {
        return RememberMeAuthenticationProvider("mySecretKey")
    }
}

