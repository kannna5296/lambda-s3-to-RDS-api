package com.example.lambdas3toRDSapp.config

import com.amazonaws.ClientConfiguration
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class StorageConfig {

    @Value("\${s3.region}")
    val region: String? = ""

    @Value("\${s3.endPoint}")
    val endPoint: String = ""

    @Bean
    fun getClient(): AmazonS3 {
        val config = ClientConfiguration()

        return AmazonS3ClientBuilder.standard().withRegion(region).build();
    }
}