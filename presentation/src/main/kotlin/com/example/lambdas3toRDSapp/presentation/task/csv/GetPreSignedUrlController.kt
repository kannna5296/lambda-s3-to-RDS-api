package com.example.lambdas3toRDSapp.presentation.task.csv

import com.example.lambdas3toRDSapp.usecase.presignedUrl.GetPreSignedUrlResponse
import com.example.lambdas3toRDSapp.usecase.presignedUrl.GetPreSignedUrlService
import com.example.lambdas3toRDSapp.usecase.presignedUrl.GetPreSingedUrlForm
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class GetPreSignedUrlController(
    private val getPreSignedUrlService: GetPreSignedUrlService
) {
    @PostMapping("/task/presign")
    fun register(@RequestBody form: GetPreSingedUrlForm): ResponseEntity<GetPreSignedUrlResponse> {
        return ResponseEntity.ok(getPreSignedUrlService.get(form))
    }
}
