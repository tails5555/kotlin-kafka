package net.kang.inventory.service

import net.kang.inventory.domain.InventoryData

interface InventoryService {
    fun loadAll(): List<InventoryData>
    fun save(data: InventoryData): InventoryData
}