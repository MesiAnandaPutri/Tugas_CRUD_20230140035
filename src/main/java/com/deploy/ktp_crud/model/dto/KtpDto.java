package com.deploy.ktp_crud.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KtpDto {

    private Integer id;
    private String nomorKtp;
    private String namaLengkap;
    private String alamat;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate tanggalLahir;

    private String jenisKelamin;
}