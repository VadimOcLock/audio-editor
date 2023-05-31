package com.example.audioeditor

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.stereotype.Component

@Configuration
@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
@EnableScheduling
class AudioEditorApplication{

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<AudioEditorApplication>(*args)
        }
    }
}





