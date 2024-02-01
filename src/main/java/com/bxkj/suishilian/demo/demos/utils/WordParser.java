package com.bxkj.suishilian.demo.demos.utils;

import com.bxkj.suishilian.demo.demos.entity.Option;
import com.bxkj.suishilian.demo.demos.entity.Question;
import com.bxkj.suishilian.demo.demos.entity.QuestionType;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;


public class WordParser {

    public static void main(String[] args) {
        String filePath = "D:\\workspace\\baoxue\\doc\\suishilian\\附录.docx"; // Word文档的路径
        String text = readWordDocument(filePath);

        // 这里可以使用之前讨论的正则表达式和解析逻辑
        // ...
        Pattern typePattern = Pattern.compile("([一二三四五六七八九十百千万亿]+、)([^（]+)（(\\d+)分，([^，]+)，共(\\d+)个小题）");
        Pattern questionPattern = Pattern.compile("(\\d+)\\.(.+?)\\n(A\\..+?\\nB\\..+?\\nC\\..+?\\nD\\..+?\\n)", Pattern.DOTALL);

        Matcher typeMatcher = typePattern.matcher(text);
        List<QuestionType> questionTypes = new ArrayList<>();

        while (typeMatcher.find()) {
            String type = typeMatcher.group(2);
            int score = Integer.parseInt(typeMatcher.group(3));
            int totalQuestions = Integer.parseInt(typeMatcher.group(5));

            QuestionType questionType = new QuestionType(type, score, totalQuestions);

            String questionsText = text.substring(typeMatcher.end());
            Matcher questionMatcher = questionPattern.matcher(questionsText);

            while (questionMatcher.find()) {
                String number = questionMatcher.group(1);
                String questionText = questionMatcher.group(2).trim();

                // 提取答案和题干
                Pattern answerPattern = Pattern.compile("[（\\\\(]([A-D]{1,5})[）\\\\)]");
                Matcher answerMatcher = answerPattern.matcher(questionText);
                String answer = answerMatcher.find() ? answerMatcher.group(1) : "";
                String stem = questionText.replaceAll("[（\\\\(]([A-D]{1,5})[）\\\\)]", "").trim();

//                Map<String, String> options = new LinkedHashMap<>();
//                Matcher optionsMatcher = Pattern.compile("(A|B|C|D)\\.(.+)").matcher(questionMatcher.group(3));
//                while (optionsMatcher.find()) {
//                    options.put(optionsMatcher.group(1), optionsMatcher.group(2).trim());
//                }
//
//                Question question = new Question(number, stem, answer, options);
                List<Option> optionsList = new ArrayList<>();
                Matcher optionsMatcher = Pattern.compile("(A|B|C|D)\\.(.+)").matcher(questionMatcher.group(3));
                while (optionsMatcher.find()) {
                    String optionKey = optionsMatcher.group(1);
                    String optionValue = optionsMatcher.group(2).trim();
                    optionsList.add(new Option(optionKey, optionValue));
                }
                int questionTypeId = 0; // 根据您的逻辑确定 questionTypeId 的值
                Question question = new Question(number, stem, answer, optionsList,questionTypeId);

                questionType.addQuestion(question);
            }

            questionTypes.add(questionType);
        }

        // 打印或处理提取的题型和题目信息
        // ...
        // 打印提取的题型和题目信息
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/suishilian", "root", "123456");

            for (QuestionType type : questionTypes) {
                // 插入题型
                String insertTypeSql = "INSERT INTO question_type (type, score) VALUES (?, ?)";
                PreparedStatement psType = conn.prepareStatement(insertTypeSql, Statement.RETURN_GENERATED_KEYS);
                psType.setString(1, type.getType());
                psType.setInt(2, type.getScore());
                psType.executeUpdate();
                ResultSet rsType = psType.getGeneratedKeys();
                int questionTypeId = 0;
                if (rsType.next()) {
                    questionTypeId = rsType.getInt(1);
                }

                for (Question question : type.getQuestions()) {
                    // 插入问题
                    String insertQuestionSql = "INSERT INTO question (question_type_id, number, stem, answer) VALUES (?, ?, ?, ?)";
                    PreparedStatement psQuestion = conn.prepareStatement(insertQuestionSql, Statement.RETURN_GENERATED_KEYS);
                    psQuestion.setInt(1, questionTypeId);
                    psQuestion.setString(2, question.getNumber());
                    psQuestion.setString(3, question.getStem());
                    psQuestion.setString(4, question.getAnswer());
                    psQuestion.executeUpdate();
                    ResultSet rsQuestion = psQuestion.getGeneratedKeys();
                    int questionId = 0;
                    if (rsQuestion.next()) {
                        questionId = rsQuestion.getInt(1);
                    }

                    // 插入选项
                    for (Option option : question.getOptions()) {
                        String insertOptionSql = "INSERT INTO `option` (question_id, label, content) VALUES (?, ?, ?)";
                        PreparedStatement psOption = conn.prepareStatement(insertOptionSql);
                        psOption.setInt(1, questionId);
                        psOption.setString(2, option.getLabel());
                        psOption.setString(3, option.getContent());
                        psOption.executeUpdate();
                    }
                }
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // 这里你可以处理异常，比如记录日志或者返回错误信息
        }
//        DatabaseInserter databaseInserter = new DatabaseInserter();
//        databaseInserter.writeDataToDB(questionTypes);
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
//                for (Map.Entry<String, String> option : question.getOptions().entrySet()) {
//                    System.out.println(option.getKey() + ": " + option.getValue());
//                }
//            }
//        }
    }

    private static String readWordDocument(String filePath) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            XWPFDocument document = new XWPFDocument(fis);
            XWPFWordExtractor extractor = new XWPFWordExtractor(document);
            String text = extractor.getText();
            fis.close();
            return text;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
