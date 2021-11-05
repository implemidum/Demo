package com.implemidum.music.dtos;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlbumGetDto {
	
	@JsonProperty("id")
    private Long id;
	
	@NotNull
	@JsonProperty("title")
    private String title;
	
	@NotNull
	@JsonProperty("description")
    private String description;
	
	@JsonProperty("group")
    private String group;
	
	@JsonProperty("songs")
	private List<SongGetDto> songs;
}
