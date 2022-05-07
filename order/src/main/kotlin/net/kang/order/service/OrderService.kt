package net.kang.order.service

import net.kang.order.domain.OrderData

interface OrderService {
    fun loadAll(): List<OrderData>
    fun save(data: OrderData): OrderData
}