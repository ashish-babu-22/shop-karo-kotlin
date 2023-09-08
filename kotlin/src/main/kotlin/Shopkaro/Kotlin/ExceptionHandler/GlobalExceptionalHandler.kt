package Shopkaro.Kotlin.ExceptionHandler

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.server.handler.ResponseStatusExceptionHandler
import java.text.SimpleDateFormat
import java.util.Date

@ControllerAdvice
class GlobalExceptionalHandler {
    var formatter :SimpleDateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
    final var dateObj : Date = Date();

    var date : String = dateObj.toString();

    @ExceptionHandler
    fun exception (exec : ProductNotFoundException) : ResponseEntity<ErrorResponse> {
        var error : ErrorResponse? = exec.message?.let { ErrorResponse(HttpStatus.NOT_FOUND.value(), it,date) };
    return ResponseEntity(error,HttpStatus.NOT_FOUND)
    }
    @ExceptionHandler
    fun exception (exec : UserNotFoundException) : ResponseEntity<ErrorResponse> {
        var error : ErrorResponse? = exec.message?.let { ErrorResponse(HttpStatus.NOT_FOUND.value(), it,date) };
    return ResponseEntity(error,HttpStatus.NOT_FOUND)
    }
    @ExceptionHandler
    fun exception (exec : Exception) : ResponseEntity<ErrorResponse> {
        var error : ErrorResponse? = exec.message?.let { ErrorResponse(HttpStatus.BAD_REQUEST.value(), it,date) };
    return ResponseEntity(error,HttpStatus.BAD_REQUEST)
    }

}