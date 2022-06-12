package com.example.lambdas3toRDSapp.infra.storage.config

import com.amazonaws.ClientConfiguration
import com.amazonaws.Protocol
import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class StorageConfig {

    @Value("\${s3.credential.accessKey}")
    val accessKey: String = ""

    @Value("\${s3.credential.secretKey}")
    val secretKey: String = ""

    @Value("\${s3.region}")
    val region: String? = ""

    @Value("\${s3.endPoint}")
    val endPoint: String = ""

    @Value("\${s3.bucketName}")
    val bucketName: String = ""

    @Value("\${s3.https}")
    val https: Boolean = false

    @Value("\${s3.connectionTimeout}")
    val connectionTimeout: Int = 0

    @Value("\${s3.readTimeout}")
    val readTimeout: Int = 0

    @Bean
    fun getClient(): AmazonS3 {

        //設定ファイルから
        val credentials = BasicAWSCredentials(accessKey, secretKey)
        val endpointConfiguration = EndpointConfiguration(endPoint, region)
        val clientConfiguration = ClientConfiguration()
        clientConfiguration.protocol = if(https) Protocol.HTTPS else Protocol.HTTP
        clientConfiguration.connectionTimeout = connectionTimeout
        clientConfiguration.requestTimeout = readTimeout

        val client = AmazonS3ClientBuilder.standard()
            .withEndpointConfiguration(endpointConfiguration)
            .withPathStyleAccessEnabled(true) //TODO これ何？
            .withClientConfiguration(clientConfiguration)
            .withCredentials(AWSStaticCredentialsProvider(credentials))
            .build();

        //Bucket存在するかチェック
        if (!client.doesBucketExistV2(bucketName)) {
            throw Exception("bucketが存在しません")
        }

        return client
    }
}