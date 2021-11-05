package com.implemidum.music.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.implemidum.music.data.MusicGroup;
import com.implemidum.music.dtos.MusicGroupGetDto;
import com.implemidum.music.dtos.MusicGroupPostDto;
import com.implemidum.music.dtos.MusicGroupSearchDto;
import com.implemidum.music.exception.ItemNotFoundException;
import com.implemidum.music.mappers.MapStructMapper;
import com.implemidum.music.repo.GroupRepository;

@RestController()
@RequestMapping("rest")
public class GroupController {

	private final GroupRepository groupRepository;
	
	private MapStructMapper mapstructMapper;

	public GroupController(
			GroupRepository groupRepository,
			MapStructMapper mapstructMapper) {
		super();
		this.groupRepository = groupRepository;
		this.mapstructMapper = mapstructMapper;
	}

	@GetMapping("/groups")
	List<MusicGroupGetDto> all() {
		List<MusicGroup> all = groupRepository.findAll();
		return mapstructMapper.allMusicGroupToMusicGroupGetDto(all);
	}

	@PostMapping("/groups")
	MusicGroupGetDto newGroup(@RequestBody MusicGroupPostDto newGroup) {
		return mapstructMapper.musicGroupToMusicGroupGetDto(groupRepository.save(mapstructMapper.musicGroupPostDtoToMusicGroup(newGroup)));
	}

	// Single item by id
	@GetMapping("/groups/{id}")
	MusicGroupGetDto oneById(@PathVariable Long id) {
		return mapstructMapper.musicGroupToMusicGroupGetDto(groupRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(MusicGroup.class.getName(), id)));
	}
	
	// Search result /groups?name=<patern>
	@GetMapping(value = "/groups", params = "name")
	List<MusicGroupSearchDto> searchByName(@RequestParam String name) {
		return mapstructMapper.listMusicGroupToMusicGroupSearchDto(groupRepository.findByNameContaining(name));
		
	}

	@PutMapping("/groups/{id}")
	MusicGroupGetDto replaceGroup(@RequestBody MusicGroup newGroup, @PathVariable Long id) {

		return groupRepository.findById(id).map(group -> {
			group.setName(newGroup.getName());
			group.setDescription(newGroup.getDescription());
			return mapstructMapper.musicGroupToMusicGroupGetDto(groupRepository.save(group));
		}).orElseGet(() -> {
			newGroup.setId(id);
			return mapstructMapper.musicGroupToMusicGroupGetDto(groupRepository.save(newGroup));
		});
	}

	@DeleteMapping("/groups/{id}")
	void deleteEmployee(@PathVariable Long id) {
		groupRepository.deleteById(id);
	}

}
