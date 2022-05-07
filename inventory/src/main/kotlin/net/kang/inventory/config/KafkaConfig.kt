package net.kang.inventory.config

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.*

@EnableKafka
@Configuration
class KafkaConfig {
    @Value("\${spring.kafka.consumer.bootstrap-servers}")
    lateinit var bootstrapServers: String

    @Value("\${spring.kafka.consumer.group-id}")
    lateinit var consumerGroupId: String

    // Consumer Configuration
    @Bean
    fun consumerFactory(): ConsumerFactory<String, String> {
        var props: MutableMap<String, Any> = mutableMapOf()
        props[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = bootstrapServers
        props[ConsumerConfig.GROUP_ID_CONFIG] = consumerGroupId
        props[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        props[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        return DefaultKafkaConsumerFactory(props)
    }

    @Bean
    fun kafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, String> {
        // 카프카 Concurrent 기반 리스너 컨테이너를 생성한다.
        var kafkaListenerContainerFactory: ConcurrentKafkaListenerContainerFactory<String, String> = ConcurrentKafkaListenerContainerFactory()
        kafkaListenerContainerFactory.consumerFactory = consumerFactory()
        return kafkaListenerContainerFactory
    }
}