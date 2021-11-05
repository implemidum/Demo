package com.implemidum.music.data;

import java.util.List;

import javax.persistence.*;

import lombok.*;

@Entity
@Data
@Table(name="ALBUM")
public class Album {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; // will be set when persisting

	@Column(name="ALBUM_TITLE", nullable = false)
    private String title;
	
	@Column(name="ALBUM_DESCRIPTION",nullable = false)
    private String description;

	public Album() {
    }
	
    public Album(String title, String description) {
        this.title = title;
        this.description = description;
    }
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "album")
    private List<Song> songs;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GROUP_ID")
    private MusicGroup musicGroup;
}
