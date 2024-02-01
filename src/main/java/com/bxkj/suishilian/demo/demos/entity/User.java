package com.bxkj.suishilian.demo.demos.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@JsonPropertyOrder({ "Id", "LoginName","Password","IsAction","CreateTime" })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("Id")
    @ApiModelProperty(position = 1)
    private Long Id;
    //    @ApiModelProperty(notes = "Year of the course")
    @JsonProperty("LoginName")
    @ApiModelProperty(position = 2)
    private String LoginName;

    //    @ApiModelProperty(notes = "Content of the course")
    @JsonProperty("Password")
    @ApiModelProperty(position = 3)
    private String Password;

    @JsonProperty("IsAction")
    @ApiModelProperty(position = 4)
    private String IsAction;


    @JsonProperty("CreateTime")
    @ApiModelProperty(position = 6)
    private String CreateTime;

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", LoginName='" + LoginName + '\'' +
                ", Password='" + Password + '\'' +
                ", IsAction='" + IsAction + '\'' +
                ", CreateTime='" + CreateTime + '\'' +
                '}';
    }
    @JsonProperty("Id")
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
    @JsonProperty("LoginName")
    public String getLoginName() {
        return LoginName;
    }

    public void setLoginName(String loginName) {
        LoginName = loginName;
    }
    @JsonProperty("Password")
    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
    @JsonProperty("IsAction")
    public String getIsAction() {
        return IsAction;
    }

    public void setIsAction(String isAction) {
        IsAction = isAction;
    }
    @JsonProperty("CreateTime")
    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }
}
