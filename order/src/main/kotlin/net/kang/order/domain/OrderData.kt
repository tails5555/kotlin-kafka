package net.kang.order.domain

import javax.persistence.*

@Entity
@Table(name = "_producer")
data class OrderData (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,

    // 상품 번호
    @Column(name = "product_id", nullable = false)
    val productId: Int,

    // 구매 수량
    @Column(name = "quantity", nullable = false)
    val quantity: Int
)