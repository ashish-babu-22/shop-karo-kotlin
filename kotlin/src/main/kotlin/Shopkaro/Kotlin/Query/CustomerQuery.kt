package Shopkaro.Kotlin.Query

import Shopkaro.Kotlin.Entities.CustomerDetails
import Shopkaro.Kotlin.Repositories.CustomerRepo
import Shopkaro.Kotlin.Service.CustomerService
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import graphql.kickstart.annotations.GraphQLQueryResolver as GraphQLQueryResolver1

@Component
class CustomerQuery : GraphQLQueryResolver {

    @Autowired
    lateinit var customerService: CustomerService
    fun listCustomers(): List<CustomerDetails?>?{
        return customerService.listCustomers()
    }
}