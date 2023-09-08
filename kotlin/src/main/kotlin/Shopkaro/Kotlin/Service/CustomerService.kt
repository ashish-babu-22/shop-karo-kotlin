package Shopkaro.Kotlin.Service

import Shopkaro.Kotlin.Entities.CustomerDetails
import Shopkaro.Kotlin.Entities.ProductDetails

interface CustomerService {

    fun addCustomer(customerDetails: CustomerDetails?): CustomerDetails?

    fun findUserId(customerDetails: CustomerDetails?): Int
    fun findUserName(id: Int): String?


    fun listCustomers(): List<CustomerDetails?>?

    fun deleteCustomer(id: Int): String?

    fun updateDetails(customerDetails: CustomerDetails)


}