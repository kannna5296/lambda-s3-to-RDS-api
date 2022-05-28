package com.example.lambdas3toRDSapp.domain.task

import java.time.LocalDateTime

class Task(
    var id: Int? = null,
    var taskName: TaskName,
    var createdAt: LocalDateTime
)