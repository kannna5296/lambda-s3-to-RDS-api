package com.example.lambdas3toRDSapp.domain.taskdetailcsv

// TODO Domain層に置いておくかは謎
// ユースケースによる？？？
interface ITaskDetailCsvRepository {
    fun prepareForSecureUpload(dirName: String, fileName: String): String
    fun upload()
}
