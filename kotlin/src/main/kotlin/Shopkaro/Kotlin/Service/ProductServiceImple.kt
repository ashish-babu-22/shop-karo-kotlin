package Shopkaro.Kotlin.Service

import Shopkaro.Kotlin.Entities.CustomerDetails
import Shopkaro.Kotlin.Entities.ProductDetails
import Shopkaro.Kotlin.ExceptionHandler.ProductNotFoundException
import Shopkaro.Kotlin.ExceptionHandler.UserNotFoundException
import Shopkaro.Kotlin.Repositories.ProductRepo
import org.springframework.beans.factory.annotation.Autowired
import java.util.*

class ProductServiceImple : ProductService {

    @Autowired
    lateinit var productRepo: ProductRepo;


    override fun deleteProductById(id: Int?) : String{
        id?.let { productRepo.deleteById(it) }?:throw ProductNotFoundException("Product with id - $id is not found")
        return "Deleted product - $id Successfully"
    }

    override fun showProducts(id: Int): List<ProductDetails> {
       return productRepo.findAll();
    }


    fun selectProductById(id: Int?): ProductDetails {
         return id?.let { productRepo.findById(it).get() }?:throw ProductNotFoundException("Product with id - $id is not found")

    }

    override fun addProduct(productDetails: ProductDetails?): ProductDetails {

        return productDetails?.let { productRepo.save(it) }?: throw ProductNotFoundException("Please enter some value")
    }

    override fun updateProduct(productDetails: ProductDetails?): ProductDetails {
        return productDetails?.let { productRepo.save(productDetails) }?:throw ProductNotFoundException("Enter Specific value")

    }


    override fun viewProductById(prodId: Int?): ProductDetails {
        return prodId?.let { productRepo.findById(it).get() }?:throw ProductNotFoundException("Product Not Found with id - $prodId")
    }

}