package com.daniel.orderapplication.service

import org.springframework.stereotype.Service

@Service
class OrderService {

    fun calculateOrder(apples: Int, oranges: Int): Double {
        val applePrice = 0.60
        val orangePrice = 0.25

        val appleCost = (apples / 2 + apples % 2) * applePrice
        val orangeCost = (oranges / 3 * 2 + oranges % 3) * orangePrice
        return appleCost + orangeCost
    }
}
