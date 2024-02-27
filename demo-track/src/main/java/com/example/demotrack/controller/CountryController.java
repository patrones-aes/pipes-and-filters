package com.example.demotrack.controller;

import com.example.demotrack.service.CountryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/ejemplo2")
    public String obtenerEjemplo() {
        return "¡Hola desde la API!";
    }


    @GetMapping("/countries")
    public List<JsonNode> getAllCountries() throws JsonProcessingException {

        return  countryService.consumeExistingService();
    }
}
