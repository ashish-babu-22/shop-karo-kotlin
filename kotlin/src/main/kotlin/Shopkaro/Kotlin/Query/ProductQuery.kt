package Shopkaro.Kotlin.Query

import Shopkaro.Kotlin.Entities.ProductDetails
import Shopkaro.Kotlin.Repositories.ProductRepo
import Shopkaro.Kotlin.Service.ProductService
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ProductQuery : GraphQLQueryResolver{

    @Autowired
    lateinit var productService: ProductService
    fun showProducts(id: Int): List<ProductDetails?>?{
        return productService.showProducts(id);
    }
    fun viewProductById(prodId: Int?): ProductDetails?{
        return productService.viewProductById(prodId)
    }


}