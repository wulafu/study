package com.study.repository;

import com.study.entity.ActiveCodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActiveCodeRepository extends JpaRepository<ActiveCodeEntity, Long> {



}
