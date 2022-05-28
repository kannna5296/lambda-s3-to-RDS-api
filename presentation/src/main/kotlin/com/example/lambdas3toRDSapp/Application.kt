package com.example.lambdas3toRDSapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan


@SpringBootApplication
@ComponentScan(
    basePackages = [
        "com.example.lambdas3toRDSapp.presentation",
        "com.example.lambdas3toRDSapp.infra",
        "com.example.lambdas3toRDSapp.domain",
        "com.example.lambdas3toRDSapp.usecase",
    ]
)
class Application
fun main(args: Array<String>) {
    runApplication<Application>(*args)
}