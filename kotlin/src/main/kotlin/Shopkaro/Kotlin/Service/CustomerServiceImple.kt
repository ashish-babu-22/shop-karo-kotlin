package Shopkaro.Kotlin.Service

import Shopkaro.Kotlin.Entities.CartDetails
import Shopkaro.Kotlin.Entities.CustomerDetails
import Shopkaro.Kotlin.ExceptionHandler.ProductNotFoundException
import Shopkaro.Kotlin.ExceptionHandler.UserNotFoundException
import Shopkaro.Kotlin.Repositories.CartRepo
import Shopkaro.Kotlin.Repositories.CustomerRepo
import org.springframework.beans.factory.annotation.Autowired
import java.util.*

class CustomerServiceImple : CustomerService{


    @Autowired
    private lateinit var customerRepo : CustomerRepo
    @Autowired
    private lateinit var cartRepo : CartRepo



    override fun addCustomer(customerDetails: CustomerDetails?): CustomerDetails {
        customerRepo.addToUserDB(customerDetails?.name, "{noop}" + customerDetails?.password)
        customerRepo.addToRolesDB(customerDetails?.name)
        val cart = CartDetails(customerDetails?.customerId?:throw UserNotFoundException("User Not found"))
        customerDetails.cartDetails=cart
        cartRepo.save(cart)
        return customerRepo.save(customerDetails) ?: throw ProductNotFoundException("Error")

    }

    override fun findUserId(customerDetails: CustomerDetails?): Int {
     if(customerDetails == null) throw UserNotFoundException("Enter Valid Credentials")
        val mail: String = customerDetails.mail
        val contact: String = customerDetails.contact
        val pass: String = customerDetails.password
        val id = customerRepo.getCustomerIdByMailAndPass(mail, pass, contact) ?:throw UserNotFoundException("User not Found")
        println(id)
        return id
    }

    override fun findUserName(id: Int): String {
        var temp : Optional<CustomerDetails> = customerRepo.findById(id) ?:throw UserNotFoundException("Error")
        return temp.get().name
    }


    override fun listCustomers(): List<CustomerDetails?>? {
        return customerRepo.findAll()
    }

    override fun deleteCustomer(id: Int): String? {
        val byId: Optional<CustomerDetails> = customerRepo.findById(id)
        if (byId.isEmpty()) throw UserNotFoundException("User ID Unknown")
        customerRepo.deleteById(id)
        return "User $id deleted Successfully"
    }

    override fun updateDetails(customerDetails: CustomerDetails) {
        customerRepo.save(customerDetails)
    }

}