package com.example.lambdas3toRDSapp.presentation

import com.example.lambdas3toRDSapp.usecase.task.RegisterForm
import com.example.lambdas3toRDSapp.usecase.task.RegisterService
import com.example.lambdas3toRDSapp.usecase.task.TaskResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class RegisterController(
    private val registerService: RegisterService
) {

    @PostMapping("/task")
    fun register(@RequestBody form: RegisterForm): ResponseEntity<TaskResponse>{
        return ResponseEntity.ok(registerService.register(form))
    }

}