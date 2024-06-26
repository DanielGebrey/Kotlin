package com.daniel.orderapplication.repository

import com.daniel.orderapplication.model.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository : JpaRepository<Order, Long>
