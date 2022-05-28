package com.example.lambdas3toRDSapp.domain.taskdetail

import java.time.LocalDateTime

class TaskDetail(
    id: Int? = null,
    taskId: Int,
    userId: Int,
    content: Content,
    createdAt: LocalDateTime
)

