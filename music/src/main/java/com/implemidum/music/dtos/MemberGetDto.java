package com.implemidum.music.dtos;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberGetDto {
	
	@JsonProperty("id")
    private Long id;
	
	@NotNull
	@JsonProperty("firstName")
    private String firstName;
	
	@NotNull
	@JsonProperty("lastName")
    private String lastName;
	
	@NotNull
	@JsonProperty("country")
    private String country;
	
	@NotNull
	@JsonProperty("countryId")
    private Long countryId;
}
