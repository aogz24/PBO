package com.agus.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.agus.project.domain.*;
import com.agus.project.services.MahasiswaServices;

import org.springframework.validation.Errors;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/mahasiswa")
public class MahasiswaController {
	
	private final MahasiswaServices mahasiswaServices;
	
	@Autowired
	public MahasiswaController(MahasiswaServices mahasiswaServices) {
		super();
		this.mahasiswaServices = mahasiswaServices;
	}

	@GetMapping("/list")
	public String findMahasiswaList(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        
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
        
        model.addAttribute("username", username);
        model.addAttribute("isAdmin", isAdmin);
		model.addAttribute("mahasiswa", mahasiswaServices.findMahasiswaAll());
		return "mahasiswa/mahasiswa-list";
	}
	
	@GetMapping("/new")
	public String loadMahasiswaForm(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        model.addAttribute("username", username);
		Mahasiswa mahasiswa = new Mahasiswa();
		model.addAttribute("mahasiswa", mahasiswa);
		return "mahasiswa/form_mahasiswa";
	}
	
	@PostMapping("/new")
	public String addNewMahasiswa(@ModelAttribute("mahasiswa") @Valid Mahasiswa mahasiswa,  
			BindingResult bindingResult, 
			Errors errors,
			Model model) {
		if(errors.hasErrors()) {
			model.addAttribute("mahasiswa", mahasiswa);
			return "mahasiswa/form_mahasiswa";
		}
		mahasiswaServices.saveMahasiswa(mahasiswa);
		return "redirect:/mahasiswa/list";
	}
	
	@GetMapping("/edit/{id}")
	public String editMahasiswaForm(@PathVariable Long id, Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        model.addAttribute("username", username);
		model.addAttribute("mahasiswa", mahasiswaServices.getMahasiswaById(id));
		return "mahasiswa/form-edit";
	}
	
	@PostMapping("/{id}")
	public String updateMahasiswa(@PathVariable Long id,
			@ModelAttribute("mahasiswa") Mahasiswa mahasiswa,
			Model model) {
		
		// get patient from database by id
		Mahasiswa existingMahasiswa = mahasiswaServices.getMahasiswaById(id);
		existingMahasiswa.setId(id);
		existingMahasiswa.setNim(mahasiswa.getNim());
		existingMahasiswa.setNama(mahasiswa.getNama());
		existingMahasiswa.setKelas(mahasiswa.getKelas());
		existingMahasiswa.setAngkatan(mahasiswa.getAngkatan());
		existingMahasiswa.setAlasan(mahasiswa.getAlasan());
		
		
		// save updated patient object
		mahasiswaServices.updateMahasiswa(existingMahasiswa);
		return "redirect:/mahasiswa/list";		
	}
	
	// handler method to handle delete patient request
	
	@GetMapping("/delete/{id}")
	public String deletePatient(@PathVariable Long id) {
		mahasiswaServices.deleteMahasiswaById(id);
		return "redirect:/mahasiswa/list";
	}
}
