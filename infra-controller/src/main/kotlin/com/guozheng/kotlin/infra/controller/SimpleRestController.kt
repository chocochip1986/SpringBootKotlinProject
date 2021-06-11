package com.guozheng.kotlin.infra.controller

import com.guozheng.kotlin.services.AnimalService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SimpleRestController(@Autowired private val animalService: AnimalService) {
    @PostMapping("/v1/api/create")
    fun create(): ResponseEntity<String> {
        return ResponseEntity.ok("CREATE LA")
    }

    @GetMapping("/v1/api/create")
    fun get(): ResponseEntity<String> {
        return ResponseEntity.ok("OK")
    }
}