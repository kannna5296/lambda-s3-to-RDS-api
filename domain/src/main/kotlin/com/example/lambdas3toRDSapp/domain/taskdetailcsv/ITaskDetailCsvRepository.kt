package com.example.lambdas3toRDSapp.domain.taskdetailcsv

interface ITaskDetailCsvRepository {
    fun get(key: String): PreSingedUrlForUpload
}
