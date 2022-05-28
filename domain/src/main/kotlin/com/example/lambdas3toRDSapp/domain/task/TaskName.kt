package com.example.lambdas3toRDSapp.domain.task

data class TaskName(val value: String){

    init {
        validate(value)
    }

    private fun validate(value: String) {
        require(value.length < 30) {""}
    }
}