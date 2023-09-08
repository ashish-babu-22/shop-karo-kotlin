package Shopkaro.Kotlin.ExceptionHandler

class UserNotFoundException : RuntimeException {
    constructor(message : String)
    constructor(message : String,cause : Throwable)
}