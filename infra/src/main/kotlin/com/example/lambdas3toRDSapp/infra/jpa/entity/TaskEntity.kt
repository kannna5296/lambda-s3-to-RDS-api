package com.example.lambdas3toRDSapp.infra.jpa.entity

import com.example.lambdas3toRDSapp.domain.task.Task
import com.example.lambdas3toRDSapp.domain.task.TaskName
import java.time.LocalDateTime
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "task")
class TaskEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,
    val taskName: String,
    val createdAt: LocalDateTime,

    @OneToMany(cascade = [CascadeType.ALL])
    @JoinColumn(name = "task_id")
    val taskDetail: Set<TaskDetailEntity>? = null
) {
    // DomainEnttiy=>JPAEntity
    constructor(task: Task) : this(
        id = task.id,
        taskName = task.taskName.value,
        createdAt = task.createdAt
    )

    // JPAEntity=>DomainEntity
    fun toDomainEntity(): Task {
        return Task(
            id = id,
            taskName = TaskName(taskName),
            createdAt = createdAt
        )
    }
}
