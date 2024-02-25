package com.example.demotrack.controller;

import com.example.demotrack.service.CountryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

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
    public String getAllCountries() throws JsonProcessingException {
        // Invocar el servicio para obtener la lista de países
        String countriesData = countryService.consumeExistingService();

        // Filtrar y procesar los datos según sea necesario
        // ...

        // Devolver los datos procesados como respuesta
        return countriesData;
    }
}
