package com.test.web.controller.interfaces;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.web.entities.Phone;

@RequestMapping(value = "/phone")
public interface PhoneControllerInterface
{
	@PostMapping("/insert")
	public Phone insert(String token, String number);

	@GetMapping("")
	public List<Phone> list();
	
	@GetMapping("/one")
	public Phone one(Long seq);
	
	@PutMapping("/change")
	public Phone changeNumber(String number, String newNumber);
	
	@DeleteMapping("/delete")
	public Phone delete(Long seq);
}
