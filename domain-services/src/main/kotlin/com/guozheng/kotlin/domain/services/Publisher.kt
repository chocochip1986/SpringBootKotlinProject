package com.guozheng.kotlin.domain.services

interface Publisher<K,V> {
    fun publish(topic: String, k: K? = null, v: V)
}