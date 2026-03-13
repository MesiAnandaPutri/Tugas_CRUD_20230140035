package com.deploy.ktp_crud.service.lmpl;

import com.deploy.ktp_crud.mapper.KtpMapper;
import com.deploy.ktp_crud.model.dto.KtpAddRequest;
import com.deploy.ktp_crud.model.dto.KtpDto;
import com.deploy.ktp_crud.model.entity.Ktp;
import com.deploy.ktp_crud.repository.KtpRepository;
import com.deploy.ktp_crud.service.KtpService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KtpServiceImpl implements KtpService {

    private final KtpRepository ktpRepository;
    private final KtpMapper ktpMapper;

    @Override
    @Transactional
    public KtpDto create(KtpAddRequest request) {
        if (ktpRepository.existsByNomorKtp(request.getNomorKtp())) {
            throw new IllegalArgumentException("Nomor KTP '" + request.getNomorKtp() + "' sudah terdaftar");
        }
        Ktp ktp = ktpMapper.toEntity(request);
        Ktp saved = ktpRepository.save(ktp);
        return ktpMapper.toDto(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<KtpDto> findAll() {
        return ktpMapper.toDtoList(ktpRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public KtpDto findById(Integer id) {
        Ktp ktp = ktpRepository.findById(id)
                .orElseThrow(() -> new jakarta.persistence.EntityNotFoundException("KTP dengan ID " + id + " tidak ditemukan"));
        return ktpMapper.toDto(ktp);
    }

    @Override
    @Transactional
    public KtpDto update(Integer id, KtpAddRequest request) {
        Ktp ktp = ktpRepository.findById(id)
                .orElseThrow(() -> new jakarta.persistence.EntityNotFoundException("KTP dengan ID " + id + " tidak ditemukan"));

        if (ktpRepository.existsByNomorKtpAndIdNot(request.getNomorKtp(), id)) {
            throw new IllegalArgumentException("Nomor KTP '" + request.getNomorKtp() + "' sudah digunakan oleh data lain");
        }

        ktpMapper.updateEntityFromRequest(request, ktp);
        Ktp updated = ktpRepository.save(ktp);
        return ktpMapper.toDto(updated);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        if (!ktpRepository.existsById(id)) {
            throw new jakarta.persistence.EntityNotFoundException("KTP dengan ID " + id + " tidak ditemukan");
        }
        ktpRepository.deleteById(id);
    }
}