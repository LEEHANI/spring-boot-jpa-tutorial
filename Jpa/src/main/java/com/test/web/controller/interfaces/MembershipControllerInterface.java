package com.test.web.controller.interfaces;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.web.entities.Membership;

@RequestMapping(value = "/membership")
public interface MembershipControllerInterface
{
	@PostMapping("")
	public Membership insert(Integer point);

	@GetMapping("")
	public List<Membership> list();
	
	@GetMapping("{seq}")
	public Membership one(@PathVariable Long seq);
}
