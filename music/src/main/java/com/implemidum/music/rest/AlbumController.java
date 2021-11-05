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
import com.implemidum.music.data.MusicGroup;
import com.implemidum.music.dtos.AlbumGetDto;
import com.implemidum.music.dtos.AlbumPostDto;
import com.implemidum.music.exception.ItemNotFoundException;
import com.implemidum.music.mappers.MapStructMapper;
import com.implemidum.music.repo.AlbumRepository;
import com.implemidum.music.repo.GroupRepository;

@RestController()
@RequestMapping("rest")
public class AlbumController {

	private final GroupRepository groupRepository;
	
	private final AlbumRepository albumRepository;
	
	private MapStructMapper mapstructMapper;

	public AlbumController(
			GroupRepository groupRepository,
			AlbumRepository albumRepository,
			MapStructMapper mapstructMapper) {
		super();
		this.groupRepository = groupRepository;
		this.albumRepository = albumRepository;
		this.mapstructMapper = mapstructMapper;
	}

	// get all albums
	@GetMapping("/albums")
	List<AlbumGetDto> allAlbums() {
		List<Album> all = albumRepository.findAll();
		return mapstructMapper.listAlbumToListAlbumGetDto(all);
	}
	
	// get albums from the group
	@GetMapping("/groups/{groupId}/albums")
	List<AlbumGetDto> groupAlbums(@PathVariable Long groupId) {
		List<Album> all = groupRepository.findById(groupId).orElseThrow(() -> new ItemNotFoundException(Album.class.getName(), groupId)).getAlbums();
		return mapstructMapper.listAlbumToListAlbumGetDto(all);
	}

	// Create new album in the group
	@PostMapping("/groups/{groupId}/albums")
	AlbumGetDto newAlbum(@RequestBody AlbumPostDto newAlbum, @PathVariable Long groupId) {
		Album createdAlbum = mapstructMapper.albumPostDtoToAlbum(newAlbum);
		createdAlbum.setMusicGroup(groupRepository.findById(groupId).orElseThrow(() -> new ItemNotFoundException(Album.class.getName(), groupId)));
		return mapstructMapper.albumToAlbumGetDto(albumRepository.save(createdAlbum));
	}

	// Single item by id
	@GetMapping("/albums/{id}")
	AlbumGetDto oneById(@PathVariable Long id) {
		return mapstructMapper.albumToAlbumGetDto(albumRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(Album.class.getName(), id)));
	}
	
	// update existing album or create new one if it does not exist
	@PutMapping("/groups/{groupId}/albums/{id}")
	AlbumGetDto replaceAlbum(@RequestBody AlbumPostDto newAlbum, @PathVariable Long groupId, @PathVariable Long id) {		
		return albumRepository.findById(id).map(album -> {
			album.setTitle(newAlbum.getTitle());
			album.setDescription(newAlbum.getDescription());
			return mapstructMapper.albumToAlbumGetDto(albumRepository.save(album));
		}).orElseGet(() -> {
			Album createdAlbum = mapstructMapper.albumPostDtoToAlbum(newAlbum);
			createdAlbum.setMusicGroup(groupRepository.findById(groupId).orElseThrow(() -> new ItemNotFoundException(MusicGroup.class.getName(), id)));
			return mapstructMapper.albumToAlbumGetDto(albumRepository.save(createdAlbum));
		});
	}

	@DeleteMapping("/albums/{id}")
	void deleteAlbum(@PathVariable Long id) {
		albumRepository.deleteById(id);
	}

}
