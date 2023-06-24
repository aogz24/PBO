package com.agus.project.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name= "mahasiswa")
public class Mahasiswa implements Serializable{

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nim", nullable = false)
	@NotBlank
	private String nim;
	
	@Column(name = "nama", nullable = false)
	@NotBlank
	private String nama;
	
	@Column(name = "kelas", nullable = false)
	@NotBlank
	private String kelas;
	
	@Column(name = "angkatan", nullable = false)
	@Positive
	private int angkatan;
	
	@Column(name = "alasan", nullable = false)
	@NotBlank
	private String alasan;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNim() {
		return nim;
	}

	public void setNim(String nim) {
		this.nim = nim;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getKelas() {
		return kelas;
	}

	public void setKelas(String kelas) {
		this.kelas = kelas;
	}

	public int getAngkatan() {
		return angkatan;
	}

	public void setAngkatan(int angkatan) {
		this.angkatan = angkatan;
	}

	public String getAlasan() {
		return alasan;
	}

	public void setAlasan(String alasan) {
		this.alasan = alasan;
	}
}
