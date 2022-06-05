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
        getPreSignedUrl()

        val task = Task(
            taskName = TaskName(form.taskName),
            createdAt = LocalDateTime.now()
        )
        taskRepository.save(task)
        return TaskResponse()
    }

    private fun getPreSignedUrl(
    ) {

        val s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.AP_NORTHEAST_1).build();
        val expiration = Date()
        var expirationInMs = expiration.time
        expirationInMs += (1000 * 60).toLong()
        expiration.time = expirationInMs

        val request = GeneratePresignedUrlRequest("container", "key")
            .withMethod(HttpMethod.PUT)
            .withExpiration(expiration)

        val url = s3.generatePresignedUrl(request).toURI().toString()
    }
}
