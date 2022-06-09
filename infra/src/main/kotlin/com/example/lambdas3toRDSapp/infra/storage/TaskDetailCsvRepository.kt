package com.example.lambdas3toRDSapp.infra.storage

import com.amazonaws.HttpMethod
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest
import com.example.lambdas3toRDSapp.domain.taskdetailcsv.ITaskDetailCsvRepository
import com.example.lambdas3toRDSapp.domain.taskdetailcsv.PreSingedUrlForUpload
import org.springframework.stereotype.Repository
import java.util.Date

@Repository
class TaskDetailCsvRepository(
    private val s3: AmazonS3
) : ITaskDetailCsvRepository {

    override fun get(key: String): PreSingedUrlForUpload{

        // 有効期限設定
        val expiration = Date()
        var expirationInMs = expiration.time
        println("Current Time :${expiration.time}")
        expirationInMs += (1000 * 60).toLong()
        expiration.time = expirationInMs
        println("Expiration Time:${expiration.time}")

        // 生成
        //TODO 設定ファイルから読ませる
        val request = GeneratePresignedUrlRequest("", "")
            .withMethod(HttpMethod.PUT)
            .withExpiration(expiration)

        val url = s3.generatePresignedUrl(request).toURI().toString()

        println("PresignedUrl:$url")
        return PreSingedUrlForUpload(url)
    }
}