package net.kang.inventory.component

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import net.kang.inventory.domain.InventoryData
import net.kang.inventory.repository.InventoryDataRepository
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class KafkaConsumerComponent (
    private val inventoryDataRepository: InventoryDataRepository
) {
    // TODO: 코드 컨벤션 작업 반드시 해야 할 거 같다...
    // Kafka Listener 에 토픽을 기재하면, 이에 해당하는 값이 Kafka 자체에서 자동 생성된다.
    @KafkaListener(topics = ["consume-from-order"])
    fun consumeFromOrder(msg: String) {
        var map: Map<String, Any>? = null
        val mapper: ObjectMapper = jacksonObjectMapper()
        val reference = object : TypeReference<Map<String, String>>() {}

        try {
            map = mapper.readValue(msg, reference)
        } catch (ex: JsonProcessingException) {
            return
        }

        val dataId: Long = if (!map.containsKey("productId")) 0L else map["productId"]!!.toString().toLong()
        val pcsQty: Int = if (!map.containsKey("quantity")) 0 else map["quantity"]!!.toString().toInt()

        // 재고 확인 이후, 해당 물건을 구매할 수 있게 되면 재고를 내린다.
        val cdata: InventoryData = inventoryDataRepository.findById(dataId).orElse(null)
        if (cdata != null && cdata.quantity >= pcsQty) {
            if (cdata.quantity >= pcsQty) {
                cdata.quantity -= pcsQty
                inventoryDataRepository.save(cdata)
            }
        }
    }
}