package com.guozheng.kotlin.domain.model.entities

import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor

@Data
@NoArgsConstructor
@Builder
class Animal(
    var id: Long?,
    var name: String?)