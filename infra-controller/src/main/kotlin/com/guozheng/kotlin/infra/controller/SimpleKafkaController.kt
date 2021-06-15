package com.guozheng.kotlin.infra.controller

import com.guozheng.kotlin.infra.kafka.producers.KafkaProducer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(consumes = ["application/json"])
class SimpleKafkaController(@Autowired private val kafkaProducer: KafkaProducer) {
    @GetMapping(value = ["/v1/api/publish"])
    fun publish(): ResponseEntity<String> {
        kafkaProducer.sendMessage("topic.one", "hi")
        return ResponseEntity.ok("SENT")
    }
}