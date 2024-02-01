package com.bxkj.suishilian.demo.demos.utils;
import com.bxkj.suishilian.demo.demos.entity.Question;
import com.bxkj.suishilian.demo.demos.entity.Section;
import com.bxkj.suishilian.demo.demos.entity.QuestionType;

import java.sql.*;
import java.util.List;
import java.util.Map;


public class DatabaseInserter {
    private Connection connectToDB() {
        String url = "jdbc:mysql://localhost:3306/suishilian";
        String username = "root";
        String password = "123456";

        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

//    public void writeDataToDB(List<QuestionType> questionTypes) {
//        Connection conn = connectToDB();
//        if (conn == null) {
//            System.out.println("数据库连接失败！");
//            return;
//        }
//
//        try {
//            // 禁用自动提交
//            conn.setAutoCommit(false);
//
//            // 遍历题型
//            for (QuestionType type : questionTypes) {
//                // 插入题型信息
//                PreparedStatement psType = conn.prepareStatement(
//                        "INSERT INTO Types (TypeName) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
//                psType.setString(1, type.getType());
//                psType.executeUpdate();
//                ResultSet rsType = psType.getGeneratedKeys();
//                int typeId = rsType.next() ? rsType.getInt(1) : -1;
//
//                // 遍历章节
//                for (Section section : type.getSections()) {
//                    // 插入章节信息
//                    PreparedStatement psSection = conn.prepareStatement(
//                            "INSERT INTO Sections (TypeID, SectionNumber, SectionTitle) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
//                    psSection.setInt(1, typeId);
//                    psSection.setString(2, section.getSectionNumber());
//                    psSection.setString(3, section.getSectionTitle());
//                    psSection.executeUpdate();
//                    ResultSet rsSection = psSection.getGeneratedKeys();
//                    int sectionId = rsSection.next() ? rsSection.getInt(1) : -1;
//
//                    // 遍历题目
//                    for (Question question : section.getQuestions()) {
//                        // 插入题目信息
//                        PreparedStatement psQuestion = conn.prepareStatement(
//                                "INSERT INTO Questions (SectionID, QuestionNumber, Stem, Answer) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
//                        psQuestion.setInt(1, sectionId);
//                        psQuestion.setString(2, question.getNumber());
//                        psQuestion.setString(3, question.getStem());
//                        psQuestion.setString(4, question.getAnswer());
//                        psQuestion.executeUpdate();
//                        ResultSet rsQuestion = psQuestion.getGeneratedKeys();
//                        int questionId = rsQuestion.next() ? rsQuestion.getInt(1) : -1;
//
//                        // 插入选项
//                        for (Map.Entry<String, String> option : question.getOptions().entrySet()) {
//                            PreparedStatement psOption = conn.prepareStatement(
//                                    "INSERT INTO Options (QuestionID, Label, Text) VALUES (?, ?, ?)");
//                            psOption.setInt(1, questionId);
//                            psOption.setString(2, option.getKey());
//                            psOption.setString(3, option.getValue());
//                            psOption.executeUpdate();
//                        }
//                    }
//                }
//            }
//
//            // 提交事务
//            conn.commit();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            try {
//                // 发生异常时回滚事务
//                if (conn != null) {
//                    conn.rollback();
//                }
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//        } finally {
//            try {
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
