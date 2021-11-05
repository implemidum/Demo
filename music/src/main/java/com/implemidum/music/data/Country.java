package com.implemidum.music.data;

import javax.persistence.*;

import lombok.*;

@Entity
@Data
@Table(name="COUNTRY")
public class Country {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; // will be set when persisting

	@Column(name="COUNTRY_NAME", nullable = false)
    private String name;
	
	@Column(name="COUNTRY_CODE_3", nullable = false)
    private String countryCode;
	
	@Column(name="COUNTRY_CODE_2", nullable = false)
    private String code;

	public Country() {
    }
	
    public Country(String name, String countryCode, String code) {
        this.name = name;
        // 3 digit code
        this.countryCode = countryCode;
        // 2 digit code
        this.code = code;
    }
}
