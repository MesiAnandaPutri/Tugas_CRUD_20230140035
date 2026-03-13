package com.deploy.ktp_crud.controller;


import com.deploy.ktp_crud.model.dto.KtpAddRequest;
import com.deploy.ktp_crud.model.dto.KtpDto;
import com.deploy.ktp_crud.service.KtpService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ktp")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class KtpController {

    private final KtpService ktpService;

    // POST /ktp - Create new KTP
    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@Valid @RequestBody KtpAddRequest request) {
        KtpDto created = ktpService.create(request);
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Data KTP berhasil ditambahkan");
        response.put("data", created);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // GET /ktp - Get all KTP
    @GetMapping
    public ResponseEntity<Map<String, Object>> findAll() {
        List<KtpDto> list = ktpService.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Data KTP berhasil diambil");
        response.put("data", list);
        response.put("total", list.size());
        return ResponseEntity.ok(response);
    }

    // GET /ktp/{id} - Get KTP by ID
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable Integer id) {
        KtpDto dto = ktpService.findById(id);
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Data KTP ditemukan");
        response.put("data", dto);
        return ResponseEntity.ok(response);
    }

    // PUT /ktp/{id} - Update KTP by ID
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(
            @PathVariable Integer id,
            @Valid @RequestBody KtpAddRequest request) {
        KtpDto updated = ktpService.update(id, request);
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Data KTP berhasil diperbarui");
        response.put("data", updated);
        return ResponseEntity.ok(response);
    }

    // DELETE /ktp/{id} - Delete KTP by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Integer id) {
        ktpService.delete(id);
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Data KTP berhasil dihapus");
        return ResponseEntity.ok(response);
    }
}