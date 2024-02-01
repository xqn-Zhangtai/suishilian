package com.bxkj.suishilian.demo.demos.utils;
import com.bxkj.suishilian.demo.demos.entity.Option;
import com.bxkj.suishilian.demo.demos.entity.Question;
import com.bxkj.suishilian.demo.demos.entity.QuestionType;

import java.util.*;
import java.util.regex.*;
public class test3 {
//    public static void main(String[] args) {
//        String text = "一、单选题（30分，1分／题，共30个小题）\n" +
//                "1.数据是指任何以电子或者其他方式对（B）的记录。\n" +
//                "A.数据\n" +
//                "B.信息\n" +
//                "C.资产\n" +
//                "D.文本\n" +
//                // ... 更多题目
//                "";
//
//        Pattern typePattern = Pattern.compile("([一二三四五六七八九十百千万亿]+、)([^（]+)（(\\d+)分，([^，]+)，共(\\d+)个小题）");
//        Pattern questionPattern = Pattern.compile("(\\d+)\\.(.+?)\\n(A\\..+?\\nB\\..+?\\nC\\..+?\\nD\\..+?\\n)", Pattern.DOTALL);
//
//        Matcher typeMatcher = typePattern.matcher(text);
//        List<QuestionType> questionTypes = new ArrayList<>();
//
//        while (typeMatcher.find()) {
//            String type = typeMatcher.group(2);
//            int score = Integer.parseInt(typeMatcher.group(3));
//            int totalQuestions = Integer.parseInt(typeMatcher.group(5));
//
//            QuestionType questionType = new QuestionType(type, score, totalQuestions);
//
//            String questionsText = text.substring(typeMatcher.end());
//            Matcher questionMatcher = questionPattern.matcher(questionsText);
//
//            while (questionMatcher.find()) {
//                String number = questionMatcher.group(1);
//                String questionText = questionMatcher.group(2).trim();
//
//                // 提取答案和题干
//                Pattern answerPattern = Pattern.compile("（([A-D])）");
//                Matcher answerMatcher = answerPattern.matcher(questionText);
//                String answer = answerMatcher.find() ? answerMatcher.group(1) : "";
//                String stem = questionText.replaceAll("（[A-D]）", "").trim();
//
//                List<Option> optionsList = new ArrayList<>();
//                Matcher optionsMatcher = Pattern.compile("(A|B|C|D)\\.(.+)").matcher(questionMatcher.group(3));
//                while (optionsMatcher.find()) {
//                    String optionKey = optionsMatcher.group(1);
//                    String optionValue = optionsMatcher.group(2).trim();
//                    optionsList.add(new Option(optionKey, optionValue));
//                }
//                Question question = new Question(number, stem, answer, optionsList);
//
//                questionType.addQuestion(question);
//            }
//
//            questionTypes.add(questionType);
//        }
//
//        // 打印或处理提取的题型和题目信息
//        // ...
//        // 打印提取的题型和题目信息
//        for (QuestionType type : questionTypes) {
//            System.out.println("题型: " + type.getType());
//            System.out.println("分数: " + type.getScore());
//            System.out.println("题目数量: " + type.getTotalQuestions());
//
//            for (Question question : type.getQuestions()) {
//                System.out.println("\n题号: " + question.getNumber());
//                System.out.println("题干: " + question.getStem());
//                System.out.println("答案: " + question.getAnswer());
//
//                System.out.println("选项:");
//                for (Option option : question.getOptions()) {
//                    System.out.println(option.getKey() + ": " + option.getValue());
//                }
//            }
//        }
//    }
}
