package com.deploy.ktp_crud.util;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Component
public class ValidationUtil {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /**
     * Validates that a NIK (Nomor Induk Kependudukan) has exactly 16 digits.
     */
    public static boolean isValidNik(String nik) {
        return nik != null && nik.matches("\\d{16}");
    }

    /**
     * Validates that the date string is in yyyy-MM-dd format and is a valid past date.
     */
    public static boolean isValidPastDate(String dateStr) {
        try {
            LocalDate date = LocalDate.parse(dateStr, DATE_FORMATTER);
            return date.isBefore(LocalDate.now());
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    /**
     * Validates that the gender value is acceptable.
     */
    public static boolean isValidGender(String gender) {
        return "Laki-laki".equals(gender) || "Perempuan".equals(gender);
    }
}