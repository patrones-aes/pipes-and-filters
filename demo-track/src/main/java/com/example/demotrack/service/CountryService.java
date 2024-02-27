package com.example.demotrack.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

@Service
public class CountryService {


    private final RestTemplate restTemplate;

    @Autowired
    public CountryService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<JsonNode> consumeExistingService() throws JsonProcessingException {
        String existingServiceUrl = "https://restcountries.com/v3.1/all";
        //	"https://restcountries.com/v3.1/name/colombia"; // URL del servicio existente


        String response = restTemplate.getForObject(existingServiceUrl, String.class);
        // Aquí puedes transformar o procesar la respuesta según tus necesidades
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode[] jsonResponseArray = objectMapper.readValue(response, JsonNode[].class);
        ArrayNode jsonArray = objectMapper.createArrayNode();

        List<JsonNode> registros = Arrays.asList(jsonResponseArray);

        List<JsonNode> registrosEnAmericas = registros.stream().filter(registro -> registro.get("region").asText().equals("Americas")).toList();

        // Iterar sobre los registros en Americas y realizar alguna operación
        for (JsonNode registro : registrosEnAmericas) {
            // Realizar alguna operación con los registros en Americas
            ObjectNode jsonRegistro = objectMapper.createObjectNode();
            jsonRegistro.put("campo1", registro.get("region").asText());
            jsonArray.add(jsonRegistro);
            System.out.println(registro.toString()); // Imprimir el nombre común
        }

        //return response;
        //return jsonArray.toString();
        return registrosEnAmericas;
    }

}
