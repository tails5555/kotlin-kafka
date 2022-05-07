package net.kang.inventory.domain

import javax.persistence.*

@Entity
@Table(name = "_inventory")
data class InventoryData (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,

    @Column(name = "name", nullable = false, length = 255)
    val name: String,   // 제품명

    @Column(name = "quantity", nullable = false)
    var quantity: Int, // 재고 수량

    @Column(name = "price", nullable = false)
    val price: Int  // 원가
)