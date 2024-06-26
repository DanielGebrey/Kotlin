package com.daniel.orderapplication.service

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class OrderServiceTests(@Autowired private val orderService: OrderService) {

    @Test
    fun `calculate total cost for apples without offer`() {
        val apples = 1
        val oranges = 0
        val expectedCost = 0.60  // price per apple
        assertEquals(expectedCost, orderService.calculateOrder(apples, oranges))
    }

    @Test
    fun `calculate total cost for oranges without offer`() {
        val apples = 0
        val oranges = 1
        val expectedCost = 0.25  // price per orange
        assertEquals(expectedCost, orderService.calculateOrder(apples, oranges))
    }

    @Test
    fun `apply buy one get one free offer on apples`() {
        val apples = 2
        val oranges = 0
        val expectedCost = 0.60  // price for one apple, second one is free
        assertEquals(expectedCost, orderService.calculateOrder(apples, oranges))
    }

    @Test
    fun `apply 3 for 2 offer on oranges`() {
        val apples = 0
        val oranges = 3
        val expectedCost = 0.50  // price for two oranges, third one is free
        assertEquals(expectedCost, orderService.calculateOrder(apples, oranges))
    }

    @Test
    fun `calculate total cost for a mix of apples and oranges with offers`() {
        val apples = 2
        val oranges = 3
        val expectedCost = 1.10  // combined cost with offers applied
        assertEquals(expectedCost, orderService.calculateOrder(apples, oranges))
    }
}
