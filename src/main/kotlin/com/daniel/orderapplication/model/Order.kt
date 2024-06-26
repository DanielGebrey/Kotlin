package com.daniel.orderapplication.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Order(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0,
    var apples: Int,
    var oranges: Int,
    var totalCost: Double
)
