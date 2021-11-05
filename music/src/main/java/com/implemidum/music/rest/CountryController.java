package com.implemidum.music.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.implemidum.music.data.Country;
import com.implemidum.music.dtos.CountryGetDto;
import com.implemidum.music.dtos.CountrySelectDto;
import com.implemidum.music.mappers.MapStructMapper;
import com.implemidum.music.repo.CountryRepository;

@RestController()
@RequestMapping("rest")
public class CountryController {

	private final CountryRepository repository;
	
	private MapStructMapper mapstructMapper;

	public CountryController(
			CountryRepository repository,
			MapStructMapper mapstructMapper) {
		super();
		this.repository = repository;
		this.mapstructMapper = mapstructMapper;
	}

	// get all albums
	@GetMapping("/countries")
	List<CountrySelectDto> allCountries() {
		List<Country> all = repository.findAll();
		return mapstructMapper.listCountryToListCountrySelectDto(all);
	}

}
