package com.guozheng.kotlin.infra.kafka.topics

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder

@Configuration
class Topics {
    @Bean
    fun topic1(): NewTopic {
        return TopicBuilder.name("topic.one").build()
    }
}