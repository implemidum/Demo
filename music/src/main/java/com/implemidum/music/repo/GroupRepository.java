package com.implemidum.music.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.implemidum.music.data.MusicGroup;

public interface GroupRepository extends JpaRepository<MusicGroup, Long> {

	Optional<MusicGroup> findByNameEquals(String name);
	
	Optional<MusicGroup> findByNameStartingWith(String prefix);
	
	Optional<MusicGroup> findByNameEndingWith(String suffix);
	
	List<MusicGroup> findByNameContaining(String infix);

}
