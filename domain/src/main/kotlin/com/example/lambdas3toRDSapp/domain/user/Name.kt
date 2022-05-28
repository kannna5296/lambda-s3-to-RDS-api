package com.example.lambdas3toRDSapp.domain.user

data class Name(val value: String){

    init {
        validate(value)
    }

    private fun validate(value: String) {
        require(value.length < 30) {""}
    }
}