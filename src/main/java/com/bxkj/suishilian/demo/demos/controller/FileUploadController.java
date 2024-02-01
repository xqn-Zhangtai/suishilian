package com.bxkj.suishilian.demo.demos.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

@RestController
@RequestMapping("/api")
@Api(tags = "UpLoad")
public class FileUploadController {
    @Value("${upload.path}")
    private String uploadPath;


    @ResponseBody
    @PostMapping("/UpLoad/UploadImage")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            if (file.isEmpty()) {
                return ResponseEntity.badRequest().body("请选择要上传的文件");
            }
            LocalDate currentDate = LocalDate.now();
            int year = currentDate.getYear();
            int month = currentDate.getMonthValue();;
//            System.out.println("当前年份是: " + year);
            // 获取当前日期的天数
            int day = currentDate.getDayOfMonth();
            String datamd =Integer.toString(month)+Integer.toString(day);

            // 指定文件上传的路径
            String uploadDir = uploadPath + File.separator + "imagestore"+ File.separator+year+""+ File.separator+datamd;

            // 创建文件夹（如果不存在）
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            // 上传文件到指定路径
            Path path = Paths.get(uploadDir + File.separator + file.getOriginalFilename());
            Files.write(path, file.getBytes());



            System.out.println("天的拼接为"+datamd);
            // 构建上传后的文件URL
            String fileURL = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/imagestore/")
                    .path(Integer.toString(year))
                    .path("/")
                    .path(datamd)
                    .path("/")
                    .path(file.getOriginalFilename())
                    .toUriString();
            return ResponseEntity.ok(fileURL);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("上传文件出错: " + e.getMessage());
        }
    }

}
