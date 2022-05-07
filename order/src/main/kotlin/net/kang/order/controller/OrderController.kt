package net.kang.order.controller

import net.kang.order.domain.OrderData
import net.kang.order.service.OrderService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderController (
    private val orderService: OrderService
){
    @GetMapping("data")
    fun loadAll(): List<OrderData> {
        return orderService.loadAll()
    }

    @PostMapping("data")
    fun execOrder(@RequestBody data: OrderData): OrderData {
        return orderService.save(data)
    }
}