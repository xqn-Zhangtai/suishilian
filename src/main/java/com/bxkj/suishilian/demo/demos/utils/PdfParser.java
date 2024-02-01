package com.bxkj.suishilian.demo.demos.utils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class PdfParser {
    public static void parsePdfFile(String filePath) {
        try {
            PDDocument document = PDDocument.load(new File(filePath));
            PDFTextStripper pdfStripper = new PDFTextStripper();

            String content = pdfStripper.getText(document);
            System.out.println(content); // 打印PDF文件内容

            // 在此处解析题目和答案内容
            // 例如，根据内容特征提取题目信息
            // ...

            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
