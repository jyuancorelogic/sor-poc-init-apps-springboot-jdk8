package com.corelogic.condosafe.staging.controllers;

import com.corelogic.condosafe.staging.common.io.ExcelFileUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/excel")
public class ExcelController {

    @GetMapping("/{fileName}/{sheetName}/{rowNum}/{columnIndex}")
    @ResponseBody
    public String loadExcel(@PathVariable String fileName,
                            @PathVariable String sheetName,
                            @PathVariable int rowNum,
                            @PathVariable int columnIndex) {
        //return "/" + fileName + "/" + sheetName + "/" + rowNum
                //+ "/" + columnIndex;
        return ExcelFileUtil.getCellData(fileName, sheetName, rowNum, columnIndex);
    }

}
