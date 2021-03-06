package com.example.lambdas3toRDSapp.infra.db.jpa.repository

import com.example.lambdas3toRDSapp.infra.db.jpa.entity.TaskDetailEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JpaTaskDetailRepository : JpaRepository<TaskDetailEntity, Int>
