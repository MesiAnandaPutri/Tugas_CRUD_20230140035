package com.deploy.ktp_crud.mapper;

import com.deploy.ktp_crud.model.dto.KtpAddRequest;
import com.deploy.ktp_crud.model.dto.KtpDto;
import com.deploy.ktp_crud.model.entity.Ktp;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface KtpMapper {

    KtpDto toDto(Ktp ktp);

    List<KtpDto> toDtoList(List<Ktp> ktpList);

    Ktp toEntity(KtpAddRequest request);

    void updateEntityFromRequest(KtpAddRequest request, @MappingTarget Ktp ktp);
}