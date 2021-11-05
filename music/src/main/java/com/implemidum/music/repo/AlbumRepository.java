package com.implemidum.music.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.implemidum.music.data.Album;


public interface AlbumRepository extends JpaRepository<Album, Long> {

	Optional<Album> findByTitleEquals(String name);
	
	Optional<Album> findByTitleStartingWith(String prefix);
	
	Optional<Album> findByTitleEndingWith(String suffix);
	
	Optional<Album> findByTitleContaining(String infix);

}
