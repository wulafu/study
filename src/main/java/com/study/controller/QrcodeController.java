package com.study.controller;

import com.study.Result;
import com.study.entity.ActiveCodeEntity;
import com.study.entity.QrcodeEntity;
import com.study.repository.ActiveCodeRepository;
import com.study.repository.QrcodeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("qrcode")
public class QrcodeController {
    @Autowired
    private QrcodeRepository qrcodeRepository;

    SimpleDateFormat sdf = new SimpleDateFormat("/yyyy.MM.dd/");

    @Value("${file.upload.path}")
    private String uploadPath;


    @GetMapping("/getQrcode")
    public Result getQrcode() {
        List<QrcodeEntity> all = qrcodeRepository.findAll();
        if(all!=null&&all.size()>0){
            return Result.success(all.get(0));
        }else{
            return Result.error("获取失败");
        }
    }

    @PostMapping("/uploadQrcode")
    @ResponseBody
    public Result uploadQrcode(@RequestParam("file") MultipartFile uploadFile,HttpServletRequest request ) throws IOException {


        // 在 uploadPath 文件夹中通过日期对上传的文件归类保存
        // 比如：/2019/06/06/cf13891e-4b95-4000-81eb-b6d70ae44930.png
        String format = sdf.format(new Date());
        File folder = new File(uploadPath + format);
        if (!folder.isDirectory()) {
            folder.mkdirs();
        }

        // 对上传的文件重命名，避免文件重名
        String oldName = uploadFile.getOriginalFilename();
        String newName = UUID.randomUUID().toString()
                + oldName.substring(oldName.lastIndexOf("."), oldName.length());
        try {
            // 文件保存
            uploadFile.transferTo(new File(folder, newName));

            // 返回上传文件的访问路径
            String filePath = request.getScheme() + "://" + request.getServerName()
                    + ":" + request.getServerPort() + "/images" + format + newName;


            List<QrcodeEntity> all = qrcodeRepository.findAll();
            if (all != null && all.size() > 0) {
                QrcodeEntity qrcodeEntity = all.get(0);
                qrcodeEntity.setCode(filePath);
                QrcodeEntity save = qrcodeRepository.save(qrcodeEntity);
                return Result.success(save);
            } else {
                QrcodeEntity qrcodeEntity = new QrcodeEntity();
                qrcodeEntity.setCode(filePath);
                qrcodeRepository.save(qrcodeEntity);
                return Result.success(qrcodeEntity);
            }

        } catch (IOException e) {
            return  Result.error("上传失败");
        }



    }




//
//        List<QrcodeEntity> all = qrcodeRepository.findAll();
//        QrcodeEntity qrcodeEntity =all.get(0);
//        qrcodeEntity.setCode(code);
//        QrcodeEntity save = qrcodeRepository.save(qrcodeEntity);
//        if(save!=null){
//            return Result.success(save);
//        }else{
//            return Result.error("新增失败");
//        }




}
