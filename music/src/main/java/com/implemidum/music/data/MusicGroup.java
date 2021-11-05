package com.implemidum.music.data;

import java.util.List;

import javax.persistence.*;

import lombok.*;

@Entity
@Data
@Table(name="MUSIC_GROUP")
public class MusicGroup {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; // will be set when persisting

	@Column(name="GROUP_NAME", nullable = false)
    private String name;
	
	@Column(name="GROUP_DESCRIPTION", nullable = false)
    private String description;

	public MusicGroup() {
    }
	
    public MusicGroup(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "musicGroup")
    private List<Member> members;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "musicGroup")
    private List<Album> albums;
}
