package com.example.lambdas3toRDSapp.presentation

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthCheckController{

    @PostMapping("/health_check")
    fun register(): ResponseEntity<Unit> {
        return ResponseEntity.ok().body(null)
    }
}
