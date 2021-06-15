package com.guozheng.kotlin.infra.kafka.producers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class KafkaProducer(
    @Autowired private val kafkaTemplate: KafkaTemplate<String, ByteArray>) {

    fun sendMessage(topic: String, message: String) {
        this.kafkaTemplate.send(topic, message.toByteArray(Charsets.UTF_8))
    }
}