package com.corelogic.condosafe.staging.managers;

//import com.amazonaws.services.s3.AmazonS3;
//import com.corelogic.condosafe.staging.aws.Connector;
import com.corelogic.condosafe.staging.sources.LandingSourceType;
//import com.corelogic.condosafe.staging.aws.receiver.Receiver;
import com.corelogic.condosafe.staging.common.CommonUtil;
import org.springframework.beans.factory.annotation.Value;

public class StagingManager {

    @Value("${aws.s3.bucket.excel}")
    private String excelBucketName;

    @Value("${aws.s3.bucket.accdb}")
    private String accdbBucketName;

    @Value("${aws.s3.bucket.csv}")
    private String csvBucketName;

    //@Autowired
    //private Connector connector;

    public void processStaging(String fileName) {
        String bucketKey = CommonUtil.getBucketKey(fileName);
        stagingData(CommonUtil.getLandingSourceTypeByExt(fileName), bucketKey);
        runParsers();
        transform();
        storeToDB();
    }

    //Rules Engines and Parsers
    public void runParsers() {
        //TODO
    }

    //Transform
    public void transform() {
        //TODO
    }

    //Send to PostgreSQL DB
    public void storeToDB() {
        //TODO
    }

    public void stagingData(LandingSourceType sourceType, String key) {

        //Obtain landing data from AWS S3

        //


        //

        //Validate pre-staging data

        //Send staging data to PostgreSQL DB
        /*
        AmazonS3 s3Client = connector.getS3Client();
        switch (sourceType.name()) {
            case "EXCEL":
                if (s3Client.doesBucketExistV2(excelBucketName)) {
                    Receiver.receive(s3Client, excelBucketName, key);
                }
                break;
            case "ACCESS":
                break;
            case "CSV":
                break;
            case "TEXT":
                break;
            default:
                break;
        }
        */
    }

}
