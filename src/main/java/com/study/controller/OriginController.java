package com.study.controller;

import com.study.Result;
import com.study.entity.OriginEntity;
import com.study.repository.ActiveCodeRepository;
import com.study.repository.OriginRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("origin")
public class OriginController {
    @Autowired
    private OriginRepository originRepository;
    @GetMapping("/getOrigins")
    public Result getOrigins(@RequestParam("pageNum") Integer pageNum,@RequestParam("pageSize") Integer pageSize) {
        Pageable pageable= PageRequest.of(pageNum,pageSize);
        PageRequest pageReques = PageRequest.of(pageNum, pageSize);

        Page<OriginEntity> all = originRepository.findAll(pageReques);
        OriginReponse originReponse = new OriginReponse();

        List<OriginEntity> content = all.getContent();
        long totalElements = all.getTotalElements();
        int totalPages = all.getTotalPages();
        int size = all.getSize();
        int number = all.getNumber();
        originReponse.setContent(content);
        originReponse.setTotalElements(totalElements);
        originReponse.setTotalPages(totalPages);
        originReponse.setTotalPages(totalPages);
        originReponse.setCurrentPage(number);
        originReponse.setCurrentPageSize(size);
        if(originReponse!=null){
            return Result.success(originReponse);
        }else{
            return Result.error("获取失败");
        }
    }

    @PostMapping("/addOrigin")
    public Result addOrigin(@RequestParam("name") String name,
                            @RequestParam("year") String year,
                            @RequestParam("manager") String manager,
                            @RequestParam("iphone") String iphone,
                            @RequestParam("applytype") String applytype) {


        OriginEntity originEntity = new OriginEntity();
        originEntity.setName(name);
        originEntity.setApplyyear(year);
        originEntity.setIphone(iphone);
        originEntity.setManager(manager);
        originEntity.setApplytype(applytype);

        List<OriginEntity> olds = originRepository.findByNameContaining(name);
        if(olds!=null&&olds.size()>0){
            return Result.error("该企业已经存在");
        }else{
            OriginEntity save = originRepository.save(originEntity);
            if(save!=null){
                return Result.success(save);
            }else{
                return Result.error("新增失败");
            }
        }

    }
    @GetMapping("/search")
    public Result search(@RequestParam("name") String name) {
        List<OriginEntity> search = originRepository.findByNameContaining(name);
        Result<List<OriginEntity>> success = Result.success(search);
        return success;
    }



}
