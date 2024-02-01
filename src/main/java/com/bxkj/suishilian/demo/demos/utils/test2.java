package com.bxkj.suishilian.demo.demos.utils;
import com.bxkj.suishilian.demo.demos.entity.Question;

import java.util.*;
import java.util.regex.*;

public class test2 {
//    public static void main(String[] args) {
//        String text = "1.数据是指任何以电子或者其他方式对（B）的记录。\n" +
//                "A.数据\n" +
//                "B.信息\n" +
//                "C.资产\n" +
//                "D.文本\n" +
//                "2.数据敏感性又称为数据（C）。\n" +
//                "A.时效性\n" +
//                "B.等级性\n" +
//                "C.价值性\n" +
//                "D.交换性\n";
//
//        List<Question> questions = new ArrayList<>();
//        Pattern pattern = Pattern.compile("(\\d+)\\.(.+?)\\n(A\\..+?\\nB\\..+?\\nC\\..+?\\nD\\..+?\\n)", Pattern.DOTALL);
//        Matcher matcher = pattern.matcher(text);
//
//        while (matcher.find()) {
//            String number = matcher.group(1);
//            String stem = matcher.group(2).trim();
//            Map<String, String> options = new LinkedHashMap<>();
//
//            Matcher optionsMatcher = Pattern.compile("(A|B|C|D)\\.(.+)").matcher(matcher.group(3));
//            while (optionsMatcher.find()) {
//                options.put(optionsMatcher.group(1), optionsMatcher.group(2).trim());
//            }
//
//            // 解析题干中的答案
//            Matcher answerMatcher = Pattern.compile("（([A-D])）").matcher(stem);
//            String answer = answerMatcher.find() ? answerMatcher.group(1) : "";
//
//            questions.add(new Question(number, stem, answer, options));
//        }
//
//        // 保存问题列表后的处理，例如打印或存储等
//        for (Question q : questions) {
//            System.out.println("题号: " + q.getNumber());
//            System.out.println("题干: " + q.getStem());
//            System.out.println("答案: " + q.getAnswer());
//            q.getOptions().forEach((key, value) -> System.out.println(key + ": " + value));
//            System.out.println();
//        }
//    }
}
