package com.agus.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agus.project.domain.Absensi;

@Repository
public interface AbsensiRepository extends JpaRepository<Absensi, Long> {
    // Tambahkan metode tambahan sesuai kebutuhan, misalnya untuk melakukan query kustom.
}

