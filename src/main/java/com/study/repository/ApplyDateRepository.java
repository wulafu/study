package com.study.repository;

import com.study.entity.ApplyDateEntity;
import com.study.entity.OriginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplyDateRepository extends JpaRepository<ApplyDateEntity, Long> {

}
