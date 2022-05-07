package net.kang.producer.service

import net.kang.producer.domain.ProducerData
import net.kang.producer.repository.ProducerDataRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import java.util.stream.StreamSupport

@Service
class ProducerServiceImpl(
    private val producerDataRepository: ProducerDataRepository
): ProducerService {
    override fun loadAll(): List<ProducerData> {
        return StreamSupport
            .stream(producerDataRepository.findAll().spliterator(), false)
            .collect(Collectors.toList())
    }
}