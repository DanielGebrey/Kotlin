package com.daniel.orderapplication.controller

import com.daniel.orderapplication.dto.OrderRequest
import com.fasterxml.jackson.databind.ObjectMapper
import com.daniel.orderapplication.model.Order
import com.daniel.orderapplication.repository.OrderRepository
import com.daniel.orderapplication.service.OrderService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.`when`
import org.mockito.kotlin.anyOrNull
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@ExtendWith(SpringExtension::class)
@WebMvcTest(OrderController::class)
class OrderControllerTests(@Autowired private val mockMvc: MockMvc, @Autowired private val objectMapper: ObjectMapper) {

    @MockBean
    private lateinit var orderService: OrderService

    @MockBean
    private lateinit var orderRepository: OrderRepository

    @Test
    fun `create order and return it`() {
        val orderRequest = OrderRequest(apples = 2, oranges = 3)
        val order = Order(id = 1, apples = 2, oranges = 3, totalCost = 1.35)

        `when`(orderService.calculateOrder(anyOrNull(), anyOrNull())).thenReturn(1.35)
        `when`(orderRepository.save(anyOrNull())).thenReturn(order)

        mockMvc.perform(post("/orders/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(orderRequest)))
                .andExpect(status().isOk)
                .andExpect(jsonPath("$.totalCost").value(1.35))
    }

    @Test
    fun `get order by ID successfully`() {
        val order = Order(id = 1, apples = 2, oranges = 3, totalCost = 1.35)
        `when`(orderRepository.findById(1)).thenReturn(java.util.Optional.of(order))

        mockMvc.perform(get("/orders/1"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.id").value(1))
    }
}