package com.example.lambdas3toRDSapp.infra.storage

import com.amazonaws.HttpMethod
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest
import com.amazonaws.services.s3.model.PutObjectRequest
import com.example.lambdas3toRDSapp.domain.taskdetailcsv.ITaskDetailCsvRepository
import org.springframework.stereotype.Repository
import java.io.File
import java.util.Date

@Repository
class TaskDetailCsvRepository(
    private val s3: AmazonS3
) : ITaskDetailCsvRepository {

    override fun prepareForSecureUpload(dirName: String, fileName: String): String {

        // 有効期限設定
        val expiration = Date()
        var expirationInMs = expiration.time
        println("Current Time :${expiration.time}")
        expirationInMs += (1000 * 60).toLong()
        expiration.time = expirationInMs
        println("Expiration Time:${expiration.time}")

        // 生成
        val request = GeneratePresignedUrlRequest(dirName, fileName)
            .withMethod(HttpMethod.PUT)
            .withExpiration(expiration)

        val url = s3.generatePresignedUrl(request).toURI().toString()

        println("PresignedUrl:$url")
        return url
    }
}
