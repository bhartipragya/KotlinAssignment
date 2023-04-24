package org.course.assignment.repository

import com.sun.jna.platform.win32.Ntifs.GenericReparseBuffer.sizeOf
import org.course.assignment.AssignmentApplication
import org.course.assignment.model.Bill
import org.course.assignment.model.Item
import org.course.assignment.model.Items
import org.course.assignment.model.Product
import org.course.assignment.service.ProductService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import java.util.*


@Repository
class OrderRepository @Autowired constructor(
        val productRepository: ProductRepository,
        val productService: ProductService
        //val bill: Bill
) {
//    companion object{
//        lateinit var bill: Bill
//    }

    fun getCalculateBill(items: List<Item>): Bill? {
        val productIds = items.map { it.id }
        val products = productRepository.findAllById(productIds)
        val finalId = products.map { it.id }
        val sortItem = items.filter { it.id in finalId }.sortedBy { it.id }
        val sortProduct = products.filter { it.id in finalId }.sortedBy { it.id }
        var bill: Bill = Bill()
        bill.totalItems = 0
        bill.totalPrice = 0.0
        for (i in 0 until finalId.size){
            if(sortItem[i].quantity < sortProduct[i].quantity){
                bill.totalItems += sortItem[i].quantity
                bill.totalPrice += (sortItem[i].quantity * sortProduct[i].price)
                //TODO update the product with reduced quantity
                productService.uQuantity(sortProduct[i], sortItem[i].quantity)
            }
        }
        return bill
       // return null
    }
}
