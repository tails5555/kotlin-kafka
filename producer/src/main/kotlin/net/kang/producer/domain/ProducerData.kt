package net.kang.producer.domain

import javax.persistence.*

@Entity
@Table(name = "_producer")
data class ProducerData (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,

    @Column(name = "name", nullable = false, length = 255)
    val name: String,

    // 재고 수량
    @Column(name = "quantity", nullable = false)
    val quantity: Int,

    // 재고 단가
    @Column(name = "price", nullable = false)
    val price: Int
)