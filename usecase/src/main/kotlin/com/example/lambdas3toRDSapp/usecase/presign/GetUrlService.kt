package com.example.lambdas3toRDSapp.usecase.presign

import com.amazonaws.auth.presign.PresignerParams.builder
import com.amazonaws.auth.profile.ProfileCredentialsProvider
import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.model.GetObjectRequest
import com.amazonaws.services.s3.model.PutObjectRequest
import org.springframework.stereotype.Service
import kotlin.time.Duration


@Service
class GetUrlService {

    fun getPreSignedUrl(
    ) {

        //Presigner作る
        //PutObjectRequest/PutObjectPresignRequestを作る
        //presignerのgenerateメソッドでURLを得る
    }
}