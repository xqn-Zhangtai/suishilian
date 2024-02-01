package com.bxkj.suishilian.demo.demos.utils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    public static void main(String[] args) {
        String text = "1.数据是指任何以电子或者其他方式对（B）的记录。\n" +
                "A.数据\n" +
                "B.信息\n" +
                "C.资产\n" +
                "D.文本\n" +
                "2.数据敏感性又称为数据（C）。\n" +
                "A.时效性\n" +
                "B.等级性\n" +
                "C.价值性\n" +
                "D.交换性\n";

        // 正则表达式匹配题号、题干和答案与选项
        Pattern pattern = Pattern.compile("(\\d+)\\.(.+?)\\n(A\\..+?\\nB\\..+?\\nC\\..+?\\nD\\..+?\\n)", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String questionNumber = matcher.group(1); // 题号
            String question = matcher.group(2).trim(); // 题干
            String options = matcher.group(3); // 选项集合

            System.out.println("题号: " + questionNumber);
            System.out.println("题干: " + question);
            // 正则表达式匹配括号内的答案
            Pattern pattern1 = Pattern.compile("（([A-D])）");
            Matcher matcher1 = pattern1.matcher(question);

            if (matcher1.find()) {
                String answer1 = matcher1.group(1); // 捕获括号内的答案
                System.out.println("答案: " + answer1);
            }

            // 分别匹配选项
            Matcher optionsMatcher = Pattern.compile("(A|B|C|D)\\.(.+)").matcher(options);
            while (optionsMatcher.find()) {
                String optionLabel = optionsMatcher.group(1); // 选项标签（A/B/C/D）
                String optionText = optionsMatcher.group(2).trim(); // 选项文本
                System.out.println(optionLabel + ": " + optionText);
            }

            System.out.println(); // 为不同题目之间添加空行分隔
        }
    }
}
