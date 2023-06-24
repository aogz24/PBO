package com.agus.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agus.project.domain.Pembayaran;

public interface PembayaranRepository extends JpaRepository<Pembayaran, Long> {
}

