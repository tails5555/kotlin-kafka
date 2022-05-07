package net.kang.inventory.repository

import net.kang.inventory.domain.InventoryData
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface InventoryDataRepository: CrudRepository<InventoryData, Long> {
}