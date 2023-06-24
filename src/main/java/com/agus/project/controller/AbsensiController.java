package com.agus.project.controller;

import java.time.LocalDateTime;
import java.util.List;

import com.agus.project.domain.Absensi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.agus.project.services.AbsensiService;

@Controller
public class AbsensiController {
    private final AbsensiService absensiService;
	private String username;

    @Autowired
    public AbsensiController(AbsensiService absensiService) {
        this.absensiService = absensiService;
    }

    @RequestMapping(value = "/absen", method = {RequestMethod.GET, RequestMethod.POST})
    public String absen(@RequestParam("username") String username) {
        this.username = username;
        LocalDateTime waktuPresensi = LocalDateTime.now();
        absensiService.absen(username, waktuPresensi);
        return "redirect:/list-absensi";
    }
    @GetMapping("/list-absensi")
    public String listAbsensi(Model model) {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
        model.addAttribute("username", username);
        List<Absensi> absensiList = absensiService.getAllAbsensi();
        model.addAttribute("absensiList", absensiList);
        return "list-absensi";
    }
}

