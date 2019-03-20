package com.test.web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller
{
	@RequestMapping("/")
	public String main()
	{
		return "hello world";
	}
}
