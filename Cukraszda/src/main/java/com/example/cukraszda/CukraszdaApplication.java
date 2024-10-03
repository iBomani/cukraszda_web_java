package com.example.cukraszda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller

public class CukraszdaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CukraszdaApplication.class, args);
	}
	@GetMapping("/cukraszda")
	public String cukraszdaFajl() {
		return "index";
	}
}
