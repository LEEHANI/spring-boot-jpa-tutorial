package com.test.web.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.web.entities.Phone;
import com.test.web.repositories.PhoneRepository;

@Service
public class PhoneService extends CommonService<Phone>
{
	@Autowired
	private PhoneRepository phoneRepository;
	
	public Phone changeNumber(String number, String newNumber)
	{
		Phone phone = phoneRepository.findByNumber(number).orElse(null);
		
		if(Objects.nonNull(phone))
		{
			phone.setNumber(newNumber);
			
			return repository.save(phone);
		}
		
		return null;
	}
}
