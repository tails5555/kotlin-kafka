package net.kang.order.repository

import net.kang.order.domain.OrderData
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderDataRepository: CrudRepository<OrderData, Long> {
}