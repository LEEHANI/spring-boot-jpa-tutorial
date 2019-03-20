package com.test.web.controller.interfaces;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.web.entities.Membership;

@RequestMapping(value = "/membership")
public interface MembershipControllerInterface
{
	@PostMapping("/insert")
	public Membership insert(Integer point);

	@GetMapping("")
	public List<Membership> list();
	
	@GetMapping("/one")
	public Membership one(Long seq);
}
