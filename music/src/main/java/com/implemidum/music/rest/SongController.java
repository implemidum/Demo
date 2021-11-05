package com.implemidum.music.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.implemidum.music.data.Album;
import com.implemidum.music.data.Song;
import com.implemidum.music.dtos.SongGetDto;
import com.implemidum.music.dtos.SongPostDto;
import com.implemidum.music.exception.ItemNotFoundException;
import com.implemidum.music.mappers.MapStructMapper;
import com.implemidum.music.repo.AlbumRepository;
import com.implemidum.music.repo.SongRepository;

@RestController()
@RequestMapping("rest")
public class SongController {

	private final SongRepository repository;
	private final AlbumRepository albumRepository;

	
	private MapStructMapper mapstructMapper;

	public SongController(
			SongRepository repository,
			AlbumRepository albumRepository,
			MapStructMapper mapstructMapper) {
		super();
		this.repository = repository;
		this.albumRepository = albumRepository;
		this.mapstructMapper = mapstructMapper;
	}
	
	// get songs from the albums
	@GetMapping("/albums/{albumId}/songs")
	List<SongGetDto> groupAlbums(@PathVariable Long albumId) {
		List<Song> all = albumRepository.findById(albumId).orElseThrow(() -> new ItemNotFoundException(Album.class.getName(), albumId)).getSongs();
		return mapstructMapper.listSongToListSongGetDto(all);
	}

	// Create new song in the album
	@PostMapping("/albums/{albumId}/songs")
	SongGetDto newSong(@RequestBody SongPostDto newSong, @PathVariable Long albumId) {
		Song createdSong = mapstructMapper.songPostDtoToSong(newSong);
		createdSong.setAlbum(albumRepository.findById(albumId).orElseThrow(() -> new ItemNotFoundException(Album.class.getName(), albumId)));
		return mapstructMapper.songToSongGetDto(repository.save(createdSong));
	}

	// Single item by id
	@GetMapping("/songs/{id}")
	SongGetDto oneById(@PathVariable Long id) {
		return mapstructMapper.songToSongGetDto(repository.findById(id).orElseThrow(() -> new ItemNotFoundException(Song.class.getName(), id)));
	}
	
	// update existing album or create new one if it does not exist
	@PutMapping("/albums/{albumId}/songs/{id}")
	SongGetDto replaceAlbum(@RequestBody SongPostDto newSong, @PathVariable Long albumId, @PathVariable Long id) {		
		return repository.findById(id).map(song -> {
			song.setTitle(newSong.getTitle());
			song.setDescription(newSong.getDescription());
			return mapstructMapper.songToSongGetDto(repository.save(song));
		}).orElseGet(() -> {
			Song createdSong = mapstructMapper.songPostDtoToSong(newSong);
			createdSong.setAlbum(albumRepository.findById(albumId).orElseThrow(() -> new ItemNotFoundException(Album.class.getName(), albumId)));
			return mapstructMapper.songToSongGetDto(repository.save(createdSong));
		});
	}

	@DeleteMapping("/songs/{id}")
	void deleteAlbum(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
