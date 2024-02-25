package com.example.demotrack.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {


	@GetMapping("/greeting")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return "Hello from api-spring";
	}

	@GetMapping("/ejemplo2")
	public String obtenerEjemplo() {
		return "¡Hola desde la API!";
	}


}
