package com.test.web.configurations;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class Auditor implements AuditorAware<String>
{
	@Override
	public Optional<String> getCurrentAuditor()
	{
		// custom code ...
		
		return Optional.of("may");
	}
}
