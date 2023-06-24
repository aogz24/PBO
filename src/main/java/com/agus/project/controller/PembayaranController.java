package com.agus.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.agus.project.domain.Pembayaran;
import com.agus.project.exception.ResourceNotFoundException;
import com.agus.project.file.FileUploadUtil;
import com.agus.project.repository.PembayaranRepository;

import java.io.IOException;
import java.util.List;

@Controller
public class PembayaranController {
	@Autowired
	private PembayaranRepository pembayaranRepository;

	@GetMapping("/pembayaran")
	public String showPembayaranForm(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        model.addAttribute("username", username);
		model.addAttribute("pembayaran", new Pembayaran());
		return "pembayaran-form";
	}

	@PostMapping("/pembayaran")
	public String processPembayaran(@ModelAttribute Pembayaran pembayaran,
			@RequestParam("imageFile") MultipartFile imageFile) throws IOException {
		String fileName = StringUtils.cleanPath(imageFile.getOriginalFilename());
		pembayaran.setImageFileName(fileName);
		pembayaran.setPaid(false);
		pembayaranRepository.save(pembayaran);

		// Simpan file gambar ke server
		// Untuk contoh ini, letakkan file gambar di direktori 'uploads' pada root
		// proyek
		String uploadDir = "uploads/";
		FileUploadUtil.saveFile(uploadDir, fileName, imageFile);

		return "redirect:/status-pembayaran";
	}

	@GetMapping("/status-pembayaran")
	public String showStatusPembayaran(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
        model.addAttribute("username", username);
		List<Pembayaran> pembayaranList = pembayaranRepository.findAll();

		boolean isAdmin = false;

		// Retrieve user's roles from Authentication object
		Object principal = authentication.getPrincipal();
		if (principal instanceof UserDetails) {
			UserDetails userDetails = (UserDetails) principal;
			for (GrantedAuthority authority : userDetails.getAuthorities()) {
				if (authority.getAuthority().equals("ADMIN") || authority.getAuthority().equals("admin")) {
					isAdmin = true;
					break;
				}
			}
		}

		model.addAttribute("pembayaranList", pembayaranList);
		model.addAttribute("isAdmin", isAdmin);
		return "status-pembayaran";
	}

	@GetMapping("/pembayaran/{id}/status")
	public String konfirmasiPembayaran(@PathVariable Long id) {
	    Pembayaran pembayaran = pembayaranRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Pembayaran not found with id: " + id));

	    pembayaran.setConfirmed();
	    pembayaranRepository.save(pembayaran);

	    return "redirect:/status-pembayaran";
	}


}
