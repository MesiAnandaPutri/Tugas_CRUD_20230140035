package com.deploy.ktp_crud.service;


import com.deploy.ktp_crud.model.dto.KtpAddRequest;
import com.deploy.ktp_crud.model.dto.KtpDto;

import java.util.List;

public interface KtpService {

    KtpDto create(KtpAddRequest request);

    List<KtpDto> findAll();

    KtpDto findById(Integer id);

    KtpDto update(Integer id, KtpAddRequest request);

    void delete(Integer id);
}