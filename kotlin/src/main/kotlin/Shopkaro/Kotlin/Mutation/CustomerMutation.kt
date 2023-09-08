package Shopkaro.Kotlin.Mutation

import Shopkaro.Kotlin.Entities.CartDetails
import Shopkaro.Kotlin.Entities.CustomerDetails
import Shopkaro.Kotlin.ExceptionHandler.ProductNotFoundException
import Shopkaro.Kotlin.ExceptionHandler.UserNotFoundException
import Shopkaro.Kotlin.Repositories.CartRepo
import Shopkaro.Kotlin.Repositories.CustomerRepo
import Shopkaro.Kotlin.Service.CustomerService
import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*
@Component
class CustomerMutation : GraphQLMutationResolver {

    @Autowired
    lateinit var customerService: CustomerService
    fun addCustomer(customerDetails: CustomerDetails?): CustomerDetails?{
        return customerService.addCustomer(customerDetails)
    }

    fun deleteCustomer(id: Int): String?{
        return customerService.deleteCustomer(id)
    }

    fun updateDetails(customerDetails: CustomerDetails){
        return customerService.updateDetails(customerDetails)
    }

}