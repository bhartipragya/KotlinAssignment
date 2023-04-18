package org.course.assignment.controller

import org.course.assignment.model.Product
import org.course.assignment.model.Products
import org.course.assignment.service.ProductService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/product")
class ProductController(val productService: ProductService) {
    @GetMapping("{id}")
    fun fetchOneProduct(
            @PathVariable id: UUID
    ): Optional<Product> {
        return productService.getProductById(id)
    }

    @GetMapping
    fun fetchAllProduct(): List<Product>{
        return productService.getAllProduct()
    }
}