package net.kang.producer.service

import net.kang.producer.domain.ProducerData

interface ProducerService {
    fun loadAll(): List<ProducerData>
}