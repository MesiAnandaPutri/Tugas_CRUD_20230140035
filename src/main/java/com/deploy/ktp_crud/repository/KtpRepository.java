package com.deploy.ktp_crud.repository;


import com.deploy.ktp_crud.model.entity.Ktp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KtpRepository extends JpaRepository<Ktp, Integer> {

    Optional<Ktp> findByNomorKtp(String nomorKtp);

    boolean existsByNomorKtp(String nomorKtp);

    boolean existsByNomorKtpAndIdNot(String nomorKtp, Integer id);
}