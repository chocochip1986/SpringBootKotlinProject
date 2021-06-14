package com.guozheng.kotlin.infra.controller

import com.google.gson.Gson
import com.guozheng.kotlin.domain.model.entities.Animal
import com.guozheng.kotlin.infra.controller.dtos.AnimalDto
import com.guozheng.kotlin.infra.controller.dtos.AnimalUpdateDto
import com.guozheng.kotlin.services.AnimalService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(consumes = ["application/json"])
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

    @GetMapping("/v1/api/findall/animals")
    fun getAll(): ResponseEntity<String> {
        val animal: List<Animal> = animalService.findAll() ?: return ResponseEntity.ok("No animals found!")
        var gson = Gson()
        return ResponseEntity.ok(gson.toJson(animal))
    }

    @PutMapping("/v1/api/update/animal")
    fun update(@RequestBody animalUpdateDto: AnimalUpdateDto): ResponseEntity<String> {
        var animal = Animal(animalUpdateDto.id, animalUpdateDto.name)
        animal = animalService.update(animal) ?: return ResponseEntity("No update occured!", HttpStatus.OK)
        return ResponseEntity.ok(animal.name)
    }

    @DeleteMapping("/v1/api/delete/animal")
    fun delete(@RequestBody animalUpdateDto: AnimalUpdateDto): ResponseEntity<String> {
        val animal = Animal(animalUpdateDto.id, animalUpdateDto.name)
        animalService.delete(animal)
        return ResponseEntity.ok("DELETED")
    }
}