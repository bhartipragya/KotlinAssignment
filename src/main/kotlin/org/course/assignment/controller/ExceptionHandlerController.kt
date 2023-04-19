package org.course.assignment.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ExceptionHandlerController: ResponseEntityExceptionHandler() {
//    @ExceptionHandler(value= [UnknownProductIdException::class])
//    fun handleUnknownProductIdException(e: UnknownProductIdException) = ResponseEntity
//    .status(HttpStatus.NOT_FOUND).body(e.message)
//
//
//    @ExceptionHandler(value = [InvalidQuantityException::class])
//    fun handleInvalidQuantityException(e: InvalidQuantityException) = ResponseEntity
//            .status(HttpStatus.BAD_REQUEST).body(e.message)


}