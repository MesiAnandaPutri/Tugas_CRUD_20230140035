package com.deploy.ktp_crud.model.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KtpAddRequest {

    @NotBlank(message = "Nomor KTP tidak boleh kosong")
    @Size(min = 16, max = 16, message = "Nomor KTP harus 16 digit")
    @Pattern(regexp = "\\d{16}", message = "Nomor KTP harus berupa 16 digit angka")
    private String nomorKtp;

    @NotBlank(message = "Nama lengkap tidak boleh kosong")
    @Size(max = 100, message = "Nama lengkap maksimal 100 karakter")
    private String namaLengkap;

    @NotBlank(message = "Alamat tidak boleh kosong")
    private String alamat;

    @NotNull(message = "Tanggal lahir tidak boleh kosong")
    @Past(message = "Tanggal lahir harus di masa lalu")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate tanggalLahir;

    @NotBlank(message = "Jenis kelamin tidak boleh kosong")
    @Pattern(regexp = "Laki-laki|Perempuan", message = "Jenis kelamin harus 'Laki-laki' atau 'Perempuan'")
    private String jenisKelamin;
}