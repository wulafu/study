package com.study.controller;

import com.study.Result;
import com.study.entity.ActiveCodeEntity;
import com.study.entity.OriginEntity;
import com.study.repository.ActiveCodeRepository;
import com.study.repository.OriginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("code")
public class ActiveCodeController {
    @Autowired
    private ActiveCodeRepository activeCodeRepository;

    @GetMapping("/getActiveCode")
    public Result getActiveCode() {
        List<ActiveCodeEntity> all = activeCodeRepository.findAll();
        if(all!=null&&all.size()>0){
            return Result.success(all.get(0));
        }else{
            return Result.error("获取失败");
        }

    }

    @PostMapping("/updateActiveCode")
    public Result updateActiveCode(@RequestParam("code") String code) {
        List<ActiveCodeEntity> all = activeCodeRepository.findAll();
        ActiveCodeEntity activeCodeEntity =all.get(0);
        activeCodeEntity.setCode(code);
        ActiveCodeEntity save = activeCodeRepository.save(activeCodeEntity);
        if(save!=null){
            return Result.success(true);
        }else{
            return Result.error("修改失败");
        }


    }



}
