package com.example.lambdas3toRDSapp.usecase.task

import com.amazonaws.HttpMethod
import com.amazonaws.regions.Regions
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest
import com.example.lambdas3toRDSapp.domain.task.ITaskRepository
import com.example.lambdas3toRDSapp.domain.task.Task
import com.example.lambdas3toRDSapp.domain.task.TaskName
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.Date

@Service
class RegisterService(
    private val taskRepository: ITaskRepository
) {

    fun register(form: RegisterForm): TaskResponse {
        val preSignedUrl = getPreSignedUrl()

        val task = Task(
            taskName = TaskName(form.taskName),
            createdAt = LocalDateTime.now()
        )
        taskRepository.save(task)
        return TaskResponse()
    }

    private fun getPreSignedUrl(): String{

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
