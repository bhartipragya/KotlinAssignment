package org.course.assignment.service

import org.course.assignment.model.Bill
import org.course.assignment.model.Item
import org.course.assignment.model.Items
import org.course.assignment.repository.OrderRepository
import org.course.assignment.repository.ProductRepository
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Component
import java.text.BreakIterator

@Component
class OrderService(
        val orderRepository: OrderRepository,
        val productRepository: ProductRepository
) {
    fun calculateBill(items: List<Item>): Bill? {
        items.forEach {
            requireNotNull(productRepository.findById(it.id)).also {}

        }
        return orderRepository.getCalculateBill(items)
    }
}