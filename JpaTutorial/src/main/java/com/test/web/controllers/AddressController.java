package com.test.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.test.web.controller.interfaces.AddressControllerInterface;
import com.test.web.entities.Address;
import com.test.web.services.AddressService;

@RestController
public class AddressController implements AddressControllerInterface
{
	@Autowired
	private AddressService addressService;

	@Override
	public Address insert(String city, String street)
	{
		return addressService.save
				(
					Address.builder()
					.city(city)
					.street(street)
					.build()
				);
	}

	@Override
	public List<Address> list()
	{
		return addressService.getList();
	}

	@Override
	public Address one(Long seq)
	{
		return addressService.getOne(seq);
	}
}
