package com.corelogic.condosafe.staging.managers;

//import com.amazonaws.services.s3.AmazonS3;
//import com.corelogic.condosafe.staging.aws.Connector;
import com.corelogic.condosafe.staging.sources.LandingSourceType;
//import com.corelogic.condosafe.staging.aws.sender.Sender;
import com.corelogic.condosafe.staging.common.CommonUtil;
import com.corelogic.condosafe.staging.common.io.ExcelFileUtil;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Component
public class LandingManager {

    private static final Log logger = LogFactory.getLog(LandingManager.class);

    @Value("${aws.s3.bucket.excel}")
    private String excelBucketName;

    @Value("${aws.s3.bucket.accdb}")
    private String accdbBucketName;

    @Value("${aws.s3.bucket.csv}")
    private String csvBucketName;

    //@Autowired
    //private Connector connector;

    //Normalize file name
    String fileNameNormalized = "";
    //Build up AWS S3 key
    String key = "";

    //Process source file data
    public void process(String fileName) {
        sanitizeSource(fileName);
        processMetadata(fileName);
        encryptPrivateData(fileName);
        sendLandingData(CommonUtil.getLandingSourceTypeByExt(fileName), fileName);
    }

    //Sanitize sources
    public void sanitizeSource(String fileName) {
       //TODO
    }

    //Validate Metadata
    public void processMetadata(String fileName) {
        logger.info("Testing: fileName:" + fileName);
        Sheet sheet = ExcelFileUtil.getExceltSheet(fileName, "Metadata");
        logger.info("Testing: sheet:" + sheet);
        Map<String, String> metadata = ExcelFileUtil.getMetaData(sheet);
        System.out.println("metadata.size:" + metadata.size());
        if (!metadata.isEmpty()) {
            metadata.entrySet().stream().forEach(entry -> {
                logger.info("Map: key: " + entry.getKey());
                logger.info("Map: value: " + entry.getValue());
            });
        }
    }

    //Normalize file names
    //TODO
    public String normalizeFileName(String fileName) {
        return fileName;
    }

    //Encrypt private data
    //TODO
    public void encryptPrivateData(String fileName) {
    }

    //Send post-processing data to AWS S3
    //The source files have been pre-sanitized and validated and the files are saved into S3
    public void sendLandingData(LandingSourceType sourceType, String fileName) {
        /*
        AmazonS3 s3Client = connector.getS3Client();
        fileNameNormalized = normalizeFileName(fileName);
        String bucketKey = CommonUtil.getBucketKey(fileName);
        switch (sourceType.name()) {
            case "EXCEL":
                if (s3Client.doesBucketExistV2(excelBucketName)) {
                    Sender.send(s3Client, excelBucketName, bucketKey, fileNameNormalized);
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
