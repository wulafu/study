package com.study.repository;

import com.study.entity.OriginEntity;
import com.study.entity.QrcodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QrcodeRepository extends JpaRepository<QrcodeEntity, Long> {

}
