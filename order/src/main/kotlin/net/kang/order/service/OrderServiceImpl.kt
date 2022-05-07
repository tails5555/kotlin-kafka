package net.kang.order.service

import net.kang.order.component.KafkaProducerComponent
import net.kang.order.domain.OrderData
import net.kang.order.repository.OrderDataRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import java.util.stream.StreamSupport

@Service
class OrderServiceImpl(
    private val orderDataRepository: OrderDataRepository,
    private val kafkaProducerComponent: KafkaProducerComponent
): OrderService {
    override fun loadAll(): List<OrderData> {
        return StreamSupport
            .stream(orderDataRepository.findAll().spliterator(), false)
            .collect(Collectors.toList())
    }

    override fun save(data: OrderData): OrderData {
        orderDataRepository.save(data)
        kafkaProducerComponent.send("consume-from-order", data) // TODO: 결과 값 받아와 반영하는 건?
        return data
    }
}