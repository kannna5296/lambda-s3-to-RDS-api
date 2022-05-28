package com.example.lambdas3toRDSapp.infra.jpa.entity

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "user")
class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,
    val name: String,

    //FetchはLazy
    @OneToMany(cascade = [CascadeType.ALL])
    @JoinColumn(name = "user_id")
    val taskDetail: Set<TaskDetailEntity>? = null
)