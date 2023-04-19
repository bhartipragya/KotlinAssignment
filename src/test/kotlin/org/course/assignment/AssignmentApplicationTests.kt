package org.course.assignment

import io.kotest.mpp.uniqueId
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import org.course.assignment.repository.ProductRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import java.util.*

@SpringBootTest
@ExtendWith(MockKExtension::class)
//@ActiveProfiles("build_local")
@AutoConfigureWebTestClient
class AssignmentApplicationTests @Autowired constructor(
        //private val repository: ProductRepository = mockk()
         val repository: ProductRepository
) {
    @Test
    fun `should return all products`(){
    val uid: UUID = UUID.fromString("798bfd69-ab23-4d0e-9766-bb2f5c4c7d05")
    var result =repository.findAll()
        assertThat(result).hasSize(20)
        result[0].apply {
            assertThat(id).isEqualTo(uid)
            assertThat(name).isEqualTo("bread")
            assertThat(imageUrl).isEqualTo("/bread.jpg")
            assertThat(price).isEqualTo(5.99)
            assertThat(quantity).isEqualTo(5)
        }
    }

    @Test
    fun `should return one product`(){
        val uid: UUID = UUID.fromString("798bfd69-ab23-4d0e-9766-bb2f5c4c7d05")
        val result = repository.findById(uid)
                result.apply {
            assert(value = true)
            assertThat("$result").isEqualTo("Optional[Product(id=798bfd69-ab23-4d0e-9766-bb2f5c4c7d05, name=bread, imageUrl=/bread.jpg, price=5.99, quantity=5)]")
        }
    }


}
