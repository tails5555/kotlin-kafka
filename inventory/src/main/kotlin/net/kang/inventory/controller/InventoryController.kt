package net.kang.inventory.controller

import net.kang.inventory.service.InventoryService
import net.kang.inventory.domain.InventoryData
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class InventoryController(
    private val inventoryService: InventoryService
) {
    @GetMapping("data")
    fun loadAll(): List<InventoryData> {
        return inventoryService.loadAll()
    }

    @PostMapping("data")
    fun save(@RequestBody data: InventoryData): InventoryData {
        return inventoryService.save(data)
    }
}