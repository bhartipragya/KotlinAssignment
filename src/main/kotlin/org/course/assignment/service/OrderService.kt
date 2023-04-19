package org.course.assignment.service

import org.course.assignment.model.Bill
import org.course.assignment.model.Item
import org.course.assignment.model.Items
import org.course.assignment.repository.OrderRepository
import org.course.assignment.repository.ProductRepository
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import java.text.BreakIterator
import kotlin.coroutines.coroutineContext

@Component
class OrderService(
        val orderRepository: OrderRepository
) {
    fun calculateBill(items: List<Item>): Bill? {
        return orderRepository.getCalculateBill(items)
    }
}