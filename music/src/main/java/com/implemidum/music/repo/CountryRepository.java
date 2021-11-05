package com.implemidum.music.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.implemidum.music.data.Country;
import com.implemidum.music.data.MusicGroup;

public interface CountryRepository extends JpaRepository<Country, Long> {
	
	Optional<Country> findByNameEquals(String name);
	
	Optional<Country> findByCountryCodeEquals(String countryCode);
	
	Optional<Country> findByCodeEquals(String code);

}
