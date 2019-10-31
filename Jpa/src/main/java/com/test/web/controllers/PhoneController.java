package com.test.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.test.web.controller.interfaces.PhoneControllerInterface;
import com.test.web.entities.Phone;
import com.test.web.services.PhoneService;

@RestController
public class PhoneController implements PhoneControllerInterface
{
	@Autowired
	private PhoneService phoneService;

	@Override
	public Phone insert(String token, String number)
	{
		return phoneService.save
				(
					Phone.builder()
					.token(token)
					.number(number)
					.build()
				);
	}

	@Override
	public List<Phone> list()
	{
		return phoneService.getList();
	}

	@Override
	public Phone one(@PathVariable Long seq)
	{
		return phoneService.getOne(seq);
	}
	
	@Override
	public Phone changeNumber(String number, String newNumber)
	{
		Phone phone = phoneService.changeNumber(number, newNumber);
		
		return phone;
	}
	
	@Override
	public Phone delete(@PathVariable Long seq)
	{
		return phoneService.delete(seq);
	}
}
