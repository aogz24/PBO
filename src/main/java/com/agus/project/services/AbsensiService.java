package com.agus.project.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.agus.project.domain.Absensi;
import com.agus.project.repository.AbsensiRepository;

@Service
public class AbsensiService {
    private final AbsensiRepository absensiRepository;

    @Autowired
    public AbsensiService(AbsensiRepository absensiRepository) {
        this.absensiRepository = absensiRepository;
    }

    public void absen(String username, LocalDateTime waktuPresensi) {
        // Simpan data absensi ke database, termasuk username dan waktu presensi
        Absensi absensi = new Absensi();
        absensi.setUsername(username);
        absensi.setWaktuPresensi(waktuPresensi);
        absensiRepository.save(absensi);
    }
    public List<Absensi> getAllAbsensi() {
        return absensiRepository.findAll();
    }
}

