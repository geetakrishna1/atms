package com.example.AtmsList.controller;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.AtmsList.model.ATM;
import com.example.AtmsList.service.AtmService;

@RestController
public class AtmController {
	
	@Autowired
	private AtmService atmService;
	private static final Logger LOG = Logger.getLogger(AtmService.class.getName());
	
	@GetMapping(value="/atms",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ATM> getAtmList() throws Exception
	{
		LOG.info("Retrieving the ATMs List");
		return atmService.getAtmList();
	}
	
	
	@GetMapping(value="/atms/{city}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ATM> getAtmListByCity(@PathVariable String city) throws Exception
	{
		LOG.info("Retrieving the ATMs List by city - "+city);
		List<ATM> listByCity = atmService.getAtmList().parallelStream().filter(atms->atms.getAddress().getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
		return listByCity;
	}

}
