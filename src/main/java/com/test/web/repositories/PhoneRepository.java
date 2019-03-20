package com.test.web.repositories;

import java.util.Optional;

import com.test.web.entities.Phone;

public interface PhoneRepository extends CommonRepository<Phone>
{
	Optional<Phone> findByNumber(String number);
}
