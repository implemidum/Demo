package com.implemidum.music.dtos;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MusicGroupGetDto {
	
	@JsonProperty("id")
    private Long id;
	
	@JsonProperty("name")
    private String name;
	
	@JsonProperty("description")
    private String description;
	
	/*
	 */
	@JsonProperty("members")
	private List<MemberGetDto> members;
	
	@JsonProperty("albums")
	private List<AlbumGetDto> albums;
}
