package Shopkaro.Kotlin.ExceptionHandler

class ProductNotFoundException : RuntimeException {

    constructor(message :String): super(message)
    constructor(message: String,cause : Throwable)
}