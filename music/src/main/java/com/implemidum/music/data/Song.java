package com.implemidum.music.data;

import javax.persistence.*;

import lombok.*;

@Entity
@Data
@Table(name = "ALBUM_SONG")
public class Song {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; // will be set when persisting

	@Column(name = "ALBUM_TITLE", nullable = false)
    private String title;
	
	@Column(name = "ALBUM_DESCRIPTION", nullable = false)
    private String description;

	public Song() {
    }
	
    public Song(String title, String description) {
        this.title = title;
        this.description = description;
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ALBUM_ID")
    private Album album;
}
