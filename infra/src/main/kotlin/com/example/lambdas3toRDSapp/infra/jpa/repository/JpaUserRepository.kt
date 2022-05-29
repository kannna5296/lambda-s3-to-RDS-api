package com.example.lambdas3toRDSapp.infra.jpa.repository

import com.example.lambdas3toRDSapp.infra.jpa.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JpaUserRepository : JpaRepository<UserEntity, Int>
