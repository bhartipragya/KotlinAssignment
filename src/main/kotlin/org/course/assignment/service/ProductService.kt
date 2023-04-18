package org.course.assignment.service

import org.course.assignment.model.Product
import org.course.assignment.repository.ProductRepository
import org.springframework.stereotype.Component
import java.util.*

@Component
class ProductService(private val repository: ProductRepository) {
    fun getProductById(id: UUID): Optional<Product> {
        return repository.findById(id)
    }
    fun getAllProduct(): List<Product>{
        return repository.findAll()
    }
}