package Shopkaro.Kotlin.Mutation

import Shopkaro.Kotlin.Entities.ProductDetails
import Shopkaro.Kotlin.Repositories.ProductRepo
import Shopkaro.Kotlin.Service.ProductService
import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ProductMutation : GraphQLMutationResolver{
    @Autowired
    lateinit var productService: ProductService


    fun deleteProductById(id: Int?) : String{
        return productService.deleteProductById(id)
    }


    fun addProduct(productDetails: ProductDetails?): ProductDetails?{
        return productService.addProduct(productDetails)
    }

    fun updateProduct(productDetails: ProductDetails?): ProductDetails?{
        return productService.updateProduct(productDetails)
    }
}