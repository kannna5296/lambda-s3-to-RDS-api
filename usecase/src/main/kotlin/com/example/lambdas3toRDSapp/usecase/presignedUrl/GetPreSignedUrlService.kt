package com.example.lambdas3toRDSapp.usecase.presignedUrl

import com.example.lambdas3toRDSapp.domain.taskdetailcsv.ITaskDetailCsvRepository
import org.springframework.stereotype.Service

@Service
class GetPreSignedUrlService(
    private val preSignedUrlRepository: ITaskDetailCsvRepository
) {

    // フォルダ名
    private val dirName = "localhost"

    fun get(form: GetPreSingedUrlForm): GetPreSignedUrlResponse {
        return GetPreSignedUrlResponse(
            preSignedUrlRepository.prepareForSecureUpload(dirName, form.fileName)
        )
    }
}
