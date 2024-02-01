package com.bxkj.suishilian.demo.demos.utils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelParser {
    public static void parseExcelFile(String filePath) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheetAt(0); // 假设你要解析第一个工作表

            for (Row row : sheet) {
                for (Cell cell : row) {
                    String cellValue = cell.getStringCellValue();
                    System.out.print(cellValue + "\t"); // 打印单元格内容

                    // 在此处解析题目和答案内容
                    // 例如，根据内容特征提取题目信息
                    // ...
                }
                System.out.println();
            }

            fis.close();
        } catch (IOException | EncryptedDocumentException e) {
            e.printStackTrace();
        }
    }
}
