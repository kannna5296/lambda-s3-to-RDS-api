package com.example.lambdas3toRDSapp.usecase.storage

import com.amazonaws.HttpMethod
import com.amazonaws.regions.Regions
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest
import org.springframework.stereotype.Service
import java.util.Date

@Service
//TODO DDD*CleanArchitectureにおける外部接続ファイルの持たせ方
//TODO infra層かも？
class StorageUtil(
    private val s3: AmazonS3
) {

    fun getPreSignedUrl(): String{

        //S3クライアント生成
        //TODO シングルとんな感じにしたい
        val s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.AP_NORTHEAST_1).build();

        // 有効期限設定
        val expiration = Date()
        var expirationInMs = expiration.time
        println("Current Time :${expiration.time}")
        expirationInMs += (1000 * 60).toLong()
        expiration.time = expirationInMs
        println("Expiration Time:${expiration.time}")

        // 生成
        val request = GeneratePresignedUrlRequest("my-test-s3-masahiro", "test.csv")
            .withMethod(HttpMethod.PUT)
            .withExpiration(expiration)
        val url = s3.generatePresignedUrl(request).toURI().toString()

        println("PresignedUrl:$url")
        return url
    }
}