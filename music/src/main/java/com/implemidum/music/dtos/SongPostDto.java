package com.implemidum.music.dtos;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SongPostDto {
	
	@JsonProperty("id")
    private Long id;
	
	@JsonProperty("albumId")
    private Long albumId;
	
	@NotNull
	@JsonProperty("title")
    private String title;
	
	@NotNull
	@JsonProperty("description")
    private String description;
}
