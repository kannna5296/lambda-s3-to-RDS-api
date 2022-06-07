package com.example.lambdas3toRDSapp.usecase.task

import com.example.lambdas3toRDSapp.domain.taskdetailcsv.ITaskDetailCsvRepository
import com.example.lambdas3toRDSapp.domain.task.ITaskRepository
import com.example.lambdas3toRDSapp.domain.task.Task
import com.example.lambdas3toRDSapp.domain.task.TaskName
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class RegisterService(
    private val taskRepository: ITaskRepository,
    private val preSignedUrlRepository: ITaskDetailCsvRepository
) {

    fun register(form: RegisterForm): TaskResponse {
        val preSignedUrl = preSignedUrlRepository.get("test.zip")

        val task = Task(
            taskName = TaskName(form.taskName),
            createdAt = LocalDateTime.now()
        )
        taskRepository.save(task)
        return TaskResponse()
    }


}
