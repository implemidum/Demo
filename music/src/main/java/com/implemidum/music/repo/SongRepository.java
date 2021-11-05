package com.implemidum.music.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.implemidum.music.data.Song;

public interface SongRepository extends JpaRepository<Song, Long> {

}
