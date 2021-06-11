package com.guozheng.kotlin.infra.controller

import com.guozheng.kotlin.domain.model.entities.Animal
import com.guozheng.kotlin.infra.controller.dtos.AnimalDto
import com.guozheng.kotlin.services.AnimalService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class SimpleRestController(@Autowired private val animalService: AnimalService) {
    @PostMapping("/v1/api/create/animal")
    fun create(@RequestBody animalDto: AnimalDto): ResponseEntity<String> {
        var animal = Animal(animalDto.name)
        animal = animalService.save(animal)
        return ResponseEntity.ok("CREATED "+animal.name)
    }

    @GetMapping("/v1/api/find/animal/{id}")
    fun get(@PathVariable("id") id: Long): ResponseEntity<String> {
        val animal: Animal = animalService.findById(id) ?: return ResponseEntity("No Animal found!", HttpStatus.OK)
        return ResponseEntity.ok(animal.toString());
    }
}