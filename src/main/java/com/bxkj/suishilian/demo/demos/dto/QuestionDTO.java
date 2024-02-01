package com.bxkj.suishilian.demo.demos.dto;

import java.util.List;

public class QuestionDTO {

    private Integer id;
    private String content;
    private List<OptionDTO> options;

    public QuestionDTO() {
    }

    public QuestionDTO(Integer id, String content) {
        this.id = id;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<OptionDTO> getOptions() {
        return options;
    }

    public void setOptions(List<OptionDTO> options) {
        this.options = options;
    }
}
