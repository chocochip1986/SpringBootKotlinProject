package com.guozheng.kotlin.infra.controller.dtos

import kotlinx.serialization.Serializable

@Serializable
data class AnimalUpdateDto(var id: Long, var name: String)