package com.agus.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.agus.project.domain.Mahasiswa;

@Repository
public interface MahasiswaRepository extends JpaRepository<Mahasiswa, Long>{

	// select * from mahasiswa
	List<Mahasiswa> findAllByNim(String nim);

	List<Mahasiswa> findAllByNama(String keyword);
	
	@Query("SELECT m FROM Mahasiswa m WHERE m.nim LIKE %:keyword% OR m.nama LIKE %:keyword% OR m.kelas LIKE %:keyword% OR m.angkatan LIKE %:keyword% OR m.alasan LIKE %:keyword%")
    List<Mahasiswa> findByKeyword(@Param("keyword") String keyword);
}
