package com.bxkj.suishilian.demo.demos.utils;
import com.bxkj.suishilian.demo.demos.entity.Option;
import com.bxkj.suishilian.demo.demos.entity.Question;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExerciseQueryExample {
    public static List<Question> getQuestionsForExercise(String questionType) {
        List<Question> questions = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/suishilian", "root", "123456")) {
            String query = "SELECT * FROM questions q " +
                    "JOIN question_types qt ON q.question_type_id = qt.id " +
                    "WHERE qt.type = ?";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setString(1, questionType);

                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        String number = rs.getString("number");
                        String stem = rs.getString("stem");
                        String answer = rs.getString("answer");

                        // Assuming you have a method to retrieve options for a question
                        List<Option> options = getOptionsForQuestion(rs.getInt("id"));
                        int questionTypeId = 0; // 根据您的逻辑确定 questionTypeId 的值
                        Question question = new Question(number, stem, answer, options,questionTypeId);
                        questions.add(question);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception (log it, throw a custom exception, etc.)
        }

        return questions;
    }

    private static List<Option> getOptionsForQuestion(int questionId) throws SQLException {
        List<Option> options = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/suishilian", "root", "123456")) {
            String query = "SELECT * FROM options WHERE question_id = ?";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setInt(1, questionId);

                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        String optionKey = rs.getString("option_key");
                        String optionValue = rs.getString("option_value");

                        Option option = new Option(optionKey, optionValue);
                        options.add(option);
                    }
                }
            }
        }

        return options;
    }

    public static void main(String[] args) {
        List<Question> practiceQuestions = getQuestionsForExercise("单选题");
        // Process the practiceQuestions as needed
        for (Question question : practiceQuestions) {
            System.out.println("题号: " + question.getNumber());
            System.out.println("题干: " + question.getStem());
            System.out.println("答案: " + question.getAnswer());


            System.out.println("选项:");
            for (Option option : question.getOptions()) {
                System.out.println(option.getLabel() + ": " + option.getContent());
            }

            System.out.println(); // 添加一个空行作为不同问题之间的分隔
        }
    }
}
