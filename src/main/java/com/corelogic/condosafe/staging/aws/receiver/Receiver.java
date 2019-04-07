package com.corelogic.condosafe.staging.aws.receiver;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.corelogic.condosafe.staging.managers.LandingManager;

public class Receiver {

    public static void receive(AmazonS3 s3Client, String bucketName, String key) {
        S3Object s3object = s3Client.getObject(bucketName, key);
        S3ObjectInputStream iStream = s3object.getObjectContent();
        //Parse the object
    }

}
