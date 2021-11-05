package com.implemidum.music.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MusicGroupSearchDto {
	
	@JsonProperty("id")
    private Long id;
	
	@JsonProperty("name")
    private String name;
	
	@JsonProperty("description")
    private String description;
	
}
