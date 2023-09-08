package Shopkaro.Kotlin.ExceptionHandler

data class ErrorResponse(var status : Int,
    var message : String,
    var time : String
) {
}