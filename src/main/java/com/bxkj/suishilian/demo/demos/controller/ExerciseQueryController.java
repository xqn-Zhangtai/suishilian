package com.bxkj.suishilian.demo.demos.controller;

import com.bxkj.suishilian.demo.demos.dao.QuestionRepository;
import com.bxkj.suishilian.demo.demos.dao.UserRepository;
import com.bxkj.suishilian.demo.demos.dto.QuestionDTO;
import com.bxkj.suishilian.demo.demos.entity.Option;
import com.bxkj.suishilian.demo.demos.entity.Question;
import com.bxkj.suishilian.demo.demos.entity.User;
import com.bxkj.suishilian.demo.demos.service.QuestionService;
import com.bxkj.suishilian.demo.demos.utils.QuestionWithOptions;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@Api(tags = "Query")
@CrossOrigin(origins = "*")
public class ExerciseQueryController {
    @Autowired
    private QuestionService questionService;

//    @PostMapping("/query/{id}")
//    @ApiOperation(value = "返回问题的集合", notes = "返回问题的集合")
//    // 根据ID获取特定题目
//    public ResponseEntity<?> getQuestionById(@PathVariable("id") Integer id) {
//        try {
//            Question question = questionService.getQuestionById(id);
//            if (question != null) {
//                return ResponseEntity.ok(question);
//            } else {
//                return ResponseEntity.notFound().build();
//            }
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
//        }
//    }
    @PostMapping("/query/{id}")
    @ApiOperation(value = "返回问题的集合", notes = "返回问题的集合")
    // 根据ID获取特定题目
    public ResponseEntity<?> getQuestionById(@PathVariable("id") Integer id) {
        try {
            Question question = questionService.getQuestionById(id);
            if (question != null) {
                // Retrieve options based on question_id
                List<Option> options = questionService.getOptionsByQuestionId(question.getId());
//                System.out.println(options);
                // Add the options to the question
//                question.setOptions(options);
                // Create QuestionWithOptions object
                QuestionWithOptions questionWithOptions = new QuestionWithOptions(question, options);


//                return ResponseEntity.ok(question);
                return ResponseEntity.ok(questionWithOptions);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}
