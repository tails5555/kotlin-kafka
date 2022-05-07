package net.kang.producer.repository

import net.kang.producer.domain.ProducerData
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProducerDataRepository: CrudRepository<ProducerData, Long> {
}