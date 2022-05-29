package com.example.lambdas3toRDSapp.infra.jpa.repository

import com.example.lambdas3toRDSapp.infra.jpa.entity.TaskEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JpaTaskRepository : JpaRepository<TaskEntity, Int>
