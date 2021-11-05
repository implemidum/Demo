package com.implemidum.music.dtos;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SongGetDto {
	
	@JsonProperty("id")
    private Long id;
	
	@NotNull
	@JsonProperty("title")
    private String title;
	
	@NotNull
	@JsonProperty("description")
    private String description;
}
