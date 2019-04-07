package com.corelogic.condosafe.staging.common.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ExcelFileUtil {

    private static final Log logger = LogFactory.getLog(ExcelFileUtil.class);

    private static Workbook getWorkbook(String fileName) {
        Workbook workbook = null;
        FileInputStream excelFileStream = null;
        try {
            excelFileStream = new FileInputStream(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            workbook = new XSSFWorkbook(excelFileStream);
        } catch(IOException ioex) {
            ioex.printStackTrace();
        }
        return workbook;
    }

    //Acquire the Excel sheet by name
    public static Sheet getExceltSheet(String fileName, String name) {
        Workbook workbook = getWorkbook(fileName);
        return workbook.getSheet(name);
    }

    public static String getCellData(String fileName, String sheetName,
                                     int rowNum, int columnIndex) {
        Sheet sheet = getExceltSheet(fileName, sheetName);
        return getCellData(sheet, rowNum, columnIndex);
    }

    public static Map<String, String> getMetaData(Sheet matadataSheet) {
        Map<String, String> metadataMap = new HashMap<String, String>();
        Iterator<Row> rows = matadataSheet.iterator();
        while (rows.hasNext()) {
            Row row = rows.next();
            logger.info("Row num: " + row.getRowNum());
            Iterator<Cell> cells = row.cellIterator();
            Double seq = 0d;
            String header = "";
            int columnIndex = 0;
            while (cells.hasNext()) {
                Cell cell = cells.next();
                logger.info("columnIndex: " + columnIndex);
                if (columnIndex == 0) {
                    seq = cell.getNumericCellValue();
                    logger.info("Cell Data: seq: " + cell.getNumericCellValue());
                } else if (columnIndex == 1) {
                    header = cell.getStringCellValue();
                    logger.info("Cell Data: field: " + cell.getStringCellValue());
                } else if (columnIndex > 1){
                    break;
                }
                columnIndex++;
            }
            metadataMap.put(String.valueOf(seq), header);
        }
        return metadataMap;
    }

    public static String getCellData(Sheet sheet, int rowNum, int columnIndex) {
        String cellData = null;
        Iterator<Row> rows = sheet.iterator();
        while (rows.hasNext()) {
            Row row = rows.next();
            if (row.getRowNum() < rowNum) {
                continue;
            } else if (row.getRowNum() > rowNum) {
                break;
            }
            Iterator<Cell> cells = row.cellIterator();
            while (cells.hasNext()) {
                Cell cell = cells.next();
                if (cell.getColumnIndex() == columnIndex) {
                    if (cell.getCellTypeEnum() == CellType.STRING) {
                        cellData = cell.getStringCellValue();
                    }
                }
            }
        }
        return cellData;
    }

}
