package net.kang.producer.service

import net.kang.producer.repository.ProducerDataRepository
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class KafkaProducerService(
    private val kafkaTemplate: KafkaTemplate<String, String>,
    private val producerDataRepository: ProducerDataRepository
) {
    fun sendOrder(topic: String, ) {

    }
}