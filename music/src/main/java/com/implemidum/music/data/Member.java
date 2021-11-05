package com.implemidum.music.data;

import javax.persistence.*;

import lombok.*;

@Entity
@Data
@Table(name = "GROUP_MEMBER")
public class Member {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; // will be set when persisting

	@Column(name = "FIRST_NAME", nullable = false)
    private String firstName;
	
	@Column(name = "LAST_NAME",nullable = false)
    private String lastName;

	public Member() {
    }
	
	public Member(Long id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
        this.lastName = lastName;
    }
	
    public Member(String firstName, String lastName, Country country) {
    	this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GROUP_ID")
    private MusicGroup musicGroup;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="COUNTRY_ID", nullable=false)
    private Country country = null;
}
