package com.agus.project.services;

import java.util.List;

import com.agus.project.domain.Mahasiswa;

public interface MahasiswaServices {

	public List<Mahasiswa> findMahasiswaAll();
	public Mahasiswa saveMahasiswa(Mahasiswa mahasiswa);
	public Mahasiswa getMahasiswaById(Long id);
	public Mahasiswa updateMahasiswa(Mahasiswa mahasiswa);
	public void deleteMahasiswaById(Long id);
	public List<Mahasiswa> searchMahasiswa(String keyword);
	public List<Mahasiswa> searchByKeyword(String keyword);
}
