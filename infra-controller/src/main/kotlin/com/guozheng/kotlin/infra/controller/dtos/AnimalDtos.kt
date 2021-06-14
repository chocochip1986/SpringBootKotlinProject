package com.guozheng.kotlin.infra.controller.dtos

import kotlinx.serialization.Serializable

@Serializable
data class AnimalDtos(var dtos: List<AnimalDto>)