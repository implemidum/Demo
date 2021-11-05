package com.implemidum.music.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountrySelectDto {
	
	@JsonProperty("id")
    private Long id;
	
	@JsonProperty("value")
    private String value;

}
