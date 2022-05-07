package net.kang.order.component

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class KafkaProducerComponent (
    private val kafkaTemplate: KafkaTemplate<String, String>
) {
    // 토픽 및 객체 데이터를 기반으로 메시지를 전송한다.
    fun send(topic: String, obj: Any) {
        val mapper: ObjectMapper = jacksonObjectMapper()
        var jsonString: String? = ""
        try {
            jsonString = mapper.writeValueAsString(obj)
        } catch (ex: JsonProcessingException) {
            ex.printStackTrace()
            return
        }

        kafkaTemplate.send(topic, jsonString)
    }
}