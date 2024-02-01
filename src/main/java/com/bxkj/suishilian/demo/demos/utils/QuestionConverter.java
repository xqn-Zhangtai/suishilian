package com.bxkj.suishilian.demo.demos.utils;

import com.bxkj.suishilian.demo.demos.dto.OptionDTO;
import com.bxkj.suishilian.demo.demos.dto.QuestionDTO;
import com.bxkj.suishilian.demo.demos.entity.Question;

import java.util.List;
import java.util.stream.Collectors;

public class QuestionConverter {
    public static QuestionDTO convertToQuestionDTO(Question question) {
        if (question == null) {
            return null;
        }

        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setId(question.getId());
        questionDTO.setContent(question.getStem());

        if (question.getOptions() != null) {
            List<OptionDTO> optionDTOs = question.getOptions().stream().map(option -> {
                OptionDTO optionDTO = new OptionDTO();
                optionDTO.setId(option.getId());
                optionDTO.setLabel(option.getLabel());
                optionDTO.setContent(option.getContent());
                return optionDTO;
            }).collect(Collectors.toList());
            questionDTO.setOptions(optionDTOs);
        }

        return questionDTO;
    }

}
