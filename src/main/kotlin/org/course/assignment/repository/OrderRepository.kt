package org.course.assignment.repository

import org.course.assignment.model.Bill
import org.course.assignment.model.Item
import org.course.assignment.model.Items
import org.course.assignment.model.Product
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import java.util.*

@Component
@Repository
interface OrderRepository {
    fun getCalculateBill(items: List<Item>): Bill? {
        return null
    }
}