package net.kang.inventory.service

import net.kang.inventory.domain.InventoryData
import net.kang.inventory.repository.InventoryDataRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import java.util.stream.StreamSupport

@Service
class InventoryServiceImpl (
    private val inventoryDataRepository: InventoryDataRepository
): InventoryService {
    // 재고 목록을 불러온다.
    override fun loadAll(): List<InventoryData> {
        return StreamSupport
            .stream(inventoryDataRepository.findAll().spliterator(), false)
            .collect(Collectors.toList())
    }

    // 재고 데이터를 새로이 저장한다.
    override fun save(data: InventoryData): InventoryData {
        return inventoryDataRepository.save(data)
    }
}