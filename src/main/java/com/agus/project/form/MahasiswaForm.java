package com.agus.project.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class MahasiswaForm {

	@NotBlank
	private String nim;
	
	@NotBlank 
	private String nama;
	
	@NotBlank 
	private String kelas;
	
	@Positive
	private int angkatan;
	
	@NotBlank
	private String alasan;
	
	
	public String getAlasan() {
		return alasan;
	}
	public void setAlasan(String alasan) {
		this.alasan = alasan;
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
	
}
