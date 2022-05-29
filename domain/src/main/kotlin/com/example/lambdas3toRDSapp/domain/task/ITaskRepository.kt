package com.example.lambdas3toRDSapp.domain.task

interface ITaskRepository {
    fun save(task: Task): Task
}
