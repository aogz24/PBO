package com.agus.project.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.agus.project.domain.*;
import com.agus.project.repository.MahasiswaRepository;
import com.agus.project.services.MahasiswaServices;

@Service
public class MahasiswaServicesImpl implements MahasiswaServices{
 
	private MahasiswaRepository mahasiswaRepository;
	
	public MahasiswaServicesImpl(MahasiswaRepository mahasiswaRepository) {
		super();
		// TODO Auto-generated constructor stub
		this.mahasiswaRepository=mahasiswaRepository;
	}

	@Override
	public List<Mahasiswa> findMahasiswaAll() {
		return mahasiswaRepository.findAll();
	}

	@Override
	public Mahasiswa saveMahasiswa(Mahasiswa mahasiswa) {
		// TODO Auto-generated method stub
		return mahasiswaRepository.save(mahasiswa);
	}

	
	@Override
	public Mahasiswa getMahasiswaById(Long id) {
		// TODO Auto-generated method stub
		return mahasiswaRepository.getReferenceById(id);
	}

	@Override
	public Mahasiswa updateMahasiswa(Mahasiswa mahasiswa) {
		// TODO Auto-generated method stub
		return mahasiswaRepository.save(mahasiswa);
	}

	@Override
	public void deleteMahasiswaById(Long id) {
		// TODO Auto-generated method stub
		mahasiswaRepository.deleteById(id);
	}
	
	public List<Mahasiswa> searchMahasiswa(String keyword) {
        return mahasiswaRepository.findAllByNama(keyword);
    }

	@Override
	public List<Mahasiswa> searchByKeyword(String keyword) {
		// TODO Auto-generated method stub
		 return mahasiswaRepository.findByKeyword(keyword);
	}

}
