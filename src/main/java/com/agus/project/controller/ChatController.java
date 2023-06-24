package com.agus.project.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {
    @PostMapping("/chat")
    public String chat(@RequestBody String userInput) {
        String response = generateResponse(userInput);
        
        return response;
    }
    
    private String generateResponse(String userInput) {
        String response;
        
        userInput = userInput.toLowerCase();
        
        if (userInput.contains("halo")) {
            response = "Halo, selamat datang di UKM Bridge STIS! Ada yang bisa saya bantu?";
        } else if (userInput.contains("ukm") || userInput.contains("sbc")) {
            response = "STIS Bridge Club (SBC) merupakan bagian dari UKM Olahraga bidang strategi yang menjadi wadah bagi mahasiswa Politeknik Statistika STIS untuk mempelajari, mengembangkan bakat, dan meraih prestasi pada cabang olahraga Bridge.";
        } else if (userInput.contains("informasi")) {
            response = "Untuk informasi terkait UKM SBC STIS, Anda dapat mengunjungi instagram @sbc.stis";
        }else if (userInput.contains("daftar")) {
            response = "Untuk mendaftar ke UKM SBC STIS, Anda dapat megakses melalui menu pendaftaran anggota atau klik disini <a href='/mahasiswa/new'>Daftar</a>";
        } else {
            response = "Maaf, saya tidak mengerti. Silakan tanyakan sesuatu tentang UKM Bridge STIS atau gunakan kata kunci yang lebih spesifik.";
        }
        
        return response;
    }
}

