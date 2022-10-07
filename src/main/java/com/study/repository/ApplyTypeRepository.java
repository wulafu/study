package com.study.repository;

import com.study.entity.ApplyTypeEntity;
import com.study.entity.OriginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplyTypeRepository extends JpaRepository<ApplyTypeEntity, Long> {

}
