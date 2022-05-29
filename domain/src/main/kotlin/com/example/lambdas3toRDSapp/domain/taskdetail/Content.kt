package com.example.lambdas3toRDSapp.domain.taskdetail

data class Content(val value: String) {

    init {
        validate(value)
    }

    private fun validate(value: String) {
        require(value.length < 300) { "" }
    }
}
