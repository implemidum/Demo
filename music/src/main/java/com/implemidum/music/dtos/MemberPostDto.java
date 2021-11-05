package com.implemidum.music.dtos;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberPostDto {
	
	@JsonProperty("id")
    private Long id;
	
	@NotNull
	@JsonProperty("firstName")
    private String firstName;
	
	@NotNull
	@JsonProperty("lastName")
    private String lastName;
	
	@JsonProperty("countryId")
    private Long countryId;
}
