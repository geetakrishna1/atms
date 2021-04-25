package com.example.AtmsList.service;


import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.AtmsList.model.ATM;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class AtmService {

	 
     private ObjectMapper objectMapper = new ObjectMapper();
	
	public List<ATM> getAtmList() throws Exception {
		// TODO Auto-generated method stub
		
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response= restTemplate.getForEntity("https://www.ing.nl/api/locator/atms/", String.class);
		String newResponse = response.getBody().substring(response.getBody().indexOf('['));
		List<ATM> atmList = objectMapper.readValue(newResponse, new TypeReference<List<ATM>>(){});
		
		return atmList;
	}

	
}
