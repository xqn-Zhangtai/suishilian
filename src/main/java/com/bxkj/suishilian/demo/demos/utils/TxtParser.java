package com.bxkj.suishilian.demo.demos.utils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TxtParser {
    public static void parseTxtFile(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line); // 打印文本文件内容

                // 在此处解析题目和答案内容
                // 例如，根据内容特征提取题目信息
                // ...
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
