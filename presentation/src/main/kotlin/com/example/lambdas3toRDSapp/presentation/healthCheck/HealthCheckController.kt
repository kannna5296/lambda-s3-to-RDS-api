package com.example.lambdas3toRDSapp.presentation.healthCheck

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthCheckController {

    @GetMapping("/health_check")
    fun register(): ResponseEntity<Unit> {
        println("HEALTHCHECK!!!!!")
        return ResponseEntity.ok().body(null)
    }
}
