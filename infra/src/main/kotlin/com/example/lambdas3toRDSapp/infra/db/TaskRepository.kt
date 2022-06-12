package com.example.lambdas3toRDSapp.infra.db

import com.example.lambdas3toRDSapp.domain.task.ITaskRepository
import com.example.lambdas3toRDSapp.domain.task.Task
import com.example.lambdas3toRDSapp.infra.db.jpa.entity.TaskEntity
import com.example.lambdas3toRDSapp.infra.db.jpa.repository.JpaTaskRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
class TaskRepository(
    private val taskRepository: JpaTaskRepository
) : ITaskRepository {

    @Transactional
    override fun save(task: Task): Task {
        return taskRepository.saveAndFlush(TaskEntity(task)).toDomainEntity()
    }
}
