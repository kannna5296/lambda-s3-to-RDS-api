package com.example.lambdas3toRDSapp.domain.taskdetail

import kotlin.test.Test
import kotlin.test.assertEquals

class ContentTest{

    @Test
    fun `作成可能`(){
        val input = "hello"
        val target = Content(input)
        assertEquals(input, target.value)
    }

}