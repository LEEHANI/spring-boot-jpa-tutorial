package com.test.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.test.web.controller.interfaces.MembershipControllerInterface;
import com.test.web.entities.Membership;
import com.test.web.services.MembershipService;

@RestController
public class MembershipController implements MembershipControllerInterface
{
	@Autowired
	private MembershipService membershipService;

	@Override
	public Membership insert(Integer point)
	{
		return membershipService.save
				(
					Membership.builder()
					.point(point)
					.build()
				);
	}

	@Override
	public List<Membership> list()
	{
		System.out.println("####membership list");
		return membershipService.getList();
	}

	@Override
	public Membership one(Long seq)
	{
		return membershipService.getOne(seq);
	}

}
