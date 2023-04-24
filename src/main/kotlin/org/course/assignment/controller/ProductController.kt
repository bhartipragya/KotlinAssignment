package org.course.assignment.controller

import org.course.assignment.model.Product
import org.course.assignment.model.Products
import org.course.assignment.service.ProductService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import java.util.*

@RestController
@RequestMapping("/products")
class ProductController(val productService: ProductService) {
//    @GetMapping(params = ["id"], produces = [MediaType.APPLICATION_JSON_VALUE])
//    fun fetchOneProduct(
//            @RequestParam id: UUID
//    ): Product? =
//         productService.getProductById(id)?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Id: $id not found")

    @GetMapping(params = ["id"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun fetchOneProduct(
            @RequestParam id: UUID
    ): Product =
            productService.getProductById(id) ?: throw UnknownProductIdException()


//} catch (e: Exception) {
//            throw  ResponseStatusException (HttpStatus.NOT_FOUND, "$id not found");
//        }
//    }



    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun fetchAllProduct(): List<Product>{
        return productService.getAllProduct()
    }
}