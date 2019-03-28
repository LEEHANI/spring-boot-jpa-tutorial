package com.test.web.controller.interfaces;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
 
import com.test.web.entities.Address;

@RequestMapping(value = "/address")
public interface AddressControllerInterface
{
	@PostMapping("")
	public Address insert(String city, String street);

	@GetMapping("")
	public List<Address> list();
	
	@GetMapping("{seq}")
	public Address one(@PathVariable Long seq);
}
