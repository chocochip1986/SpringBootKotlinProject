package com.guozheng.kotlin.infra.kafka.consumers

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class KafkaConsumer {
    @KafkaListener(topics = ["topic.one"], containerFactory = "")
    fun consume(record: ConsumerRecord<String, ByteArray>) {
        println(String(record.value()))
    }
}