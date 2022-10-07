package com.study.controller;

import com.study.entity.ApplyDateEntity;
import com.study.entity.ApplyTypeEntity;

import java.util.List;

public class HomeModelReponse {
    List<ApplyTypeEntity> applyTypeEntitys;

    public List<ApplyTypeEntity> getApplyTypeEntitys() {
        return applyTypeEntitys;
    }

    public void setApplyTypeEntitys(List<ApplyTypeEntity> applyTypeEntitys) {
        this.applyTypeEntitys = applyTypeEntitys;
    }

    public List<ApplyDateEntity> getApplyDateEntitys() {
        return applyDateEntitys;
    }

    public void setApplyDateEntitys(List<ApplyDateEntity> applyDateEntitys) {
        this.applyDateEntitys = applyDateEntitys;
    }

    List<ApplyDateEntity> applyDateEntitys;

}
