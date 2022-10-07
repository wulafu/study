package com.study.controller;

import com.study.entity.ApplyDateEntity;
import com.study.entity.ApplyTypeEntity;
import com.study.entity.OriginEntity;

import java.util.List;

public class OriginReponse {
    List<OriginEntity> content;
    long totalElements ;
    int totalPages ;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getCurrentPageSize() {
        return currentPageSize;
    }

    public void setCurrentPageSize(int currentPageSize) {
        this.currentPageSize = currentPageSize;
    }

    int currentPage ;
    int currentPageSize ;

    public List<OriginEntity> getContent() {
        return content;
    }

    public void setContent(List<OriginEntity> content) {
        this.content = content;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
