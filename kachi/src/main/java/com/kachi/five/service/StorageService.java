package com.kachi.five.service;

import java.io.File;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

public class StorageService {

    private AmazonS3 s3client;
    private String bucketName;

    public StorageService(String accessKey, String secretKey, String region, String bucketName) {
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKey, secretKey);
        this.s3client = AmazonS3ClientBuilder.standard()
                            .withRegion(region)
                            .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                            .build();
        this.bucketName = bucketName;
    }

    public void uploadFile(String keyName, File file) {
        s3client.putObject(bucketName, keyName, file);
    }
}

