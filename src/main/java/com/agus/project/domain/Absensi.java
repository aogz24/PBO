package com.agus.project.domain;

import java.time.LocalDateTime;

import com.agus.project.login.User;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "absensi")
public class Absensi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private LocalDateTime waktuPresensi;

    // Tambahkan atribut lain yang sesuai, misalnya tanggal absensi, waktu, dll.

    // Buatlah konstruktor, getter, dan setter sesuai kebutuhan.

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getWaktuPresensi() {
		return waktuPresensi;
	}

	public void setWaktuPresensi(LocalDateTime waktuPresensi) {
		this.waktuPresensi = waktuPresensi;
	}

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
