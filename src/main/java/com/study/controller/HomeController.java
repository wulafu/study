package com.study.controller;

import com.study.Result;
import com.study.entity.ActiveCodeEntity;
import com.study.entity.ApplyDateEntity;
import com.study.entity.ApplyTypeEntity;
import com.study.repository.ActiveCodeRepository;
import com.study.repository.ApplyDateRepository;
import com.study.repository.ApplyTypeRepository;
import com.study.repository.OriginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("home")
public class HomeController {
    @Autowired
    private ApplyDateRepository applyDateRepository;
    @Autowired
    private ApplyTypeRepository applyTypeRepository;
    @GetMapping("/getDisplayMessage")
    public Result getDisplayMessage() {
        List<ApplyTypeEntity> applyTypeRepositoryAll = applyTypeRepository.findAll();
        List<ApplyDateEntity> applyDateRepositoryAll = applyDateRepository.findAll();
        HomeModelReponse homeModelReponse=new HomeModelReponse();
        homeModelReponse.setApplyDateEntitys(applyDateRepositoryAll);
        homeModelReponse.setApplyTypeEntitys(applyTypeRepositoryAll);
        return Result.success(homeModelReponse);
    }



}
