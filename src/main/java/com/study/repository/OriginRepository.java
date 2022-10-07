package com.study.repository;

import com.study.entity.OriginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OriginRepository extends JpaRepository<OriginEntity, Long> {
    List<OriginEntity> findByNameContaining(String name);
}
