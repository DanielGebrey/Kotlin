package com.daniel.orderapplication.controller

import com.daniel.orderapplication.dto.OrderRequest
import com.daniel.orderapplication.model.Order
import com.daniel.orderapplication.repository.OrderRepository
import com.daniel.orderapplication.service.OrderService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/orders")
class OrderController(
    private val orderService: OrderService,
    private val orderRepository: OrderRepository
) {
    @PostMapping("/create")
    fun createOrder(@RequestBody orderRequest: OrderRequest): ResponseEntity<Order> {
        val totalCost = orderService.calculateOrder(orderRequest.apples, orderRequest.oranges)
        val order = Order(apples = orderRequest.apples, oranges = orderRequest.oranges, totalCost = totalCost)
        orderRepository.save(order)
        return ResponseEntity.ok(order)
    }

    @GetMapping("/{id}")
    fun getOrderById(@PathVariable id: Long): ResponseEntity<Order> =
        orderRepository.findById(id).map { ResponseEntity.ok(it) }
            .orElseGet { ResponseEntity.notFound().build() }

    @GetMapping("/all")
    fun getAllOrders(): ResponseEntity<List<Order>> =
        ResponseEntity.ok(orderRepository.findAll())
}
