package Shopkaro.Kotlin.Service

import Shopkaro.Kotlin.Entities.CustomerDetails
import Shopkaro.Kotlin.Entities.ProductDetails
import Shopkaro.Kotlin.ExceptionHandler.ProductNotFoundException
import Shopkaro.Kotlin.Repositories.ProductRepo
import org.springframework.beans.factory.annotation.Autowired

class ProductServiceImple : ProductService {

    @Autowired
    lateinit var productRepo: ProductRepo;
    override fun showProducts(id: Int): List<ProductDetails?>? {

        return productRepo.findAll()
    }

    override fun deleteProductById(id: Int) {
        productRepo.deleteById(id)
    }

    override fun addProduct(productDetails: ProductDetails?): ProductDetails? {
        TODO("Not yet implemented")
    }

    override fun updateProduct(productDetails: ProductDetails?): ProductDetails? {
        TODO("Not yet implemented")
    }

    override fun updateDetails(customerDetails: CustomerDetails?) {
        TODO("Not yet implemented")
    }

    override fun vewProductById(prodId: Int): ProductDetails? {
        TODO("Not yet implemented")
    }
}