package com.corelogic.condosafe.staging.aws.sender;

import com.amazonaws.services.s3.AmazonS3;
import com.corelogic.condosafe.staging.managers.LandingManager;

import java.io.File;

public class Sender {

    public static void send(AmazonS3 s3Client, String bucketName, String key, String fileName) {
        s3Client.putObject(bucketName, key, new File(fileName));
    }

}
