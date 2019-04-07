package com.corelogic.condosafe.staging.common;

import com.corelogic.condosafe.staging.sources.LandingSourceType;

public class CommonUtil {

    public static String getBucketKey(String fileName) {
        //TODO
        return "";
    }

    public static LandingSourceType getLandingSourceTypeBySeq(int seq) {
        for (LandingSourceType type : LandingSourceType.values()) {
            if (type.sequence() == seq) {
                return type;
            }
        }
        return null;
    }

    public static LandingSourceType getLandingSourceTypeByExt(String fileName) {
        int index = fileName.lastIndexOf(".");
        String ext = fileName.substring(index + 1);
        LandingSourceType type = null;
        switch (ext) {
            case "xlsx":
            case "xls":
                type = LandingSourceType.EXCEL;
                break;
            case "ccsdb":
                type = LandingSourceType.ACCESS;
                break;
            case "csv":
                type = LandingSourceType.CSV;
                break;
            case "text":
                type = LandingSourceType.TXT;
                break;
            default:
                break;
        }
        return type;
    }

}
