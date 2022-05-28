package com.example.lambdas3toRDSapp.domain.user

import kotlin.test.Test
import kotlin.test.assertEquals

class NameTest{

    @Test
    fun `作成可能`(){
        val input = "taro"
        val target = Name(input)
        assertEquals(input, target.value)
    }

}