package com.implemidum.music.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountryGetDto {
	
	@JsonProperty("id")
    private Long id;
	
	@JsonProperty("name")
    private String name;
	
	@JsonProperty("countryCode")
    private String countryCode;
	
	@JsonProperty("code")
    private String code;
}
