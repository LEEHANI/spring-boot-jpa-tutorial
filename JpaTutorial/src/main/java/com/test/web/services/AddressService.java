package com.test.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.web.entities.Address;
import com.test.web.repositories.AddressRepository;

@Service
public class AddressService extends CommonService<Address>
{
	@Autowired
	private AddressRepository addressRepository;
	
	public Address getOne(Long seq)
	{
		return addressRepository.getOne(seq);
	}
	
	public List<Address> getList()
	{
		return addressRepository.findAll();
	}
}
