package net.kang.producer.controller

import net.kang.producer.domain.ProducerData
import net.kang.producer.service.ProducerService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ProducerController (
    private val producerService: ProducerService
){
    @GetMapping("data")
    fun loadAll(): List<ProducerData> {
        return producerService.loadAll()
    }
}