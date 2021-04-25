package com.example.AtmsList;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.example.AtmsList.controller.AtmController;
import com.example.AtmsList.model.ATM;
import com.example.AtmsList.model.Address;
import com.example.AtmsList.service.AtmService;


@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
public class AtmControllerTest {
	
	@Mock
	AtmService atmService;
	
	@InjectMocks
	AtmController atmController;
   
	private String city = "Hoeven";
	List<ATM> atmList;
	
	@Before
	public void setup()
	{
		
		 atmList = new ArrayList<ATM>();
		    Address address = new Address();
	        address.setCity(city);
	        address.setHouseNumber("91");
	        address.setPostalCode("4741 AN");
	        address.setStreet("St. Janstraat");
	        ATM atm =new ATM();
	        atm.setAddress(address);
	        atm.setDistance(0);
	        atmList.add(atm); 
	        Address address2 = new Address();
	        address2.setCity(city);
	        address2.setHouseNumber("5");
	        address2.setPostalCode("4741 AM");
	        address2.setStreet("Raadhuisplein");
	        ATM atm2 =new ATM();
	        atm2.setAddress(address);
	        atm2.setDistance(0);
	        atmList.add(atm2);
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getAtmListByCity() throws Exception
	{
		
		when(atmService.getAtmList()).thenReturn(atmList);
		assertEquals(atmList, atmController.getAtmListByCity(city));	
	}
	
	@Test
	public void getAtmList() throws Exception
	{
		when(atmService.getAtmList()).thenReturn(atmList);
		assertEquals(atmList, atmController.getAtmList());
	}

}
