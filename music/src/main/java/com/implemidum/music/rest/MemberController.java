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

import com.implemidum.music.data.Country;
import com.implemidum.music.data.Member;
import com.implemidum.music.data.MusicGroup;
import com.implemidum.music.dtos.MemberGetDto;
import com.implemidum.music.dtos.MemberPostDto;
import com.implemidum.music.exception.ItemNotFoundException;
import com.implemidum.music.mappers.MapStructMapper;
import com.implemidum.music.repo.MemberRepository;
import com.implemidum.music.repo.CountryRepository;
import com.implemidum.music.repo.GroupRepository;

@RestController()
@RequestMapping("rest")
public class MemberController {

	private final GroupRepository groupRepository;
	
	private final MemberRepository memberRepository;
	
	private final CountryRepository countryRepository;
	
	private MapStructMapper mapstructMapper;

	public MemberController(
			GroupRepository groupRepository,
			MemberRepository memberRepository,
			MapStructMapper mapstructMapper,
			CountryRepository countryRepository) {
		super();
		this.groupRepository = groupRepository;
		this.memberRepository = memberRepository;
		this.countryRepository = countryRepository;
		this.mapstructMapper = mapstructMapper;
	}

	// get all members
	@GetMapping("/members")
	List<MemberGetDto> allMembers() {
		List<Member> all = memberRepository.findAll();
		return mapstructMapper.listMemberToListMemberGetDto(all);
	}
	
	// get members from the group
	@GetMapping("/groups/{groupId}/members")
	List<MemberGetDto> groupMembers(@PathVariable Long groupId) {
		List<Member> all = groupRepository.findById(groupId).orElseThrow(() -> new ItemNotFoundException(Member.class.getName(), groupId)).getMembers();
		return mapstructMapper.listMemberToListMemberGetDto(all);
	}

	// Create new member in the group
	@PostMapping("/groups/{groupId}/members")
	MemberGetDto newMember(@RequestBody MemberPostDto newMember, @PathVariable Long groupId) {
		
		Country country = countryRepository.findById(newMember.getCountryId()).orElseThrow(() -> new ItemNotFoundException(Country.class.getName(), newMember.getCountryId()));
		Member createdMember = new Member(newMember.getFirstName(), newMember.getLastName(), country);
		createdMember.setMusicGroup(groupRepository.findById(groupId).orElseThrow(() -> new ItemNotFoundException(Member.class.getName(), groupId)));
		createdMember.setCountry(country);
		return mapstructMapper.memberToMemberGetDto(memberRepository.save(createdMember));
	}

	// Single item by id
	@GetMapping("/members/{id}")
	MemberGetDto oneById(@PathVariable Long id) {
		return mapstructMapper.memberToMemberGetDto(memberRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(Member.class.getName(), id)));
	}
	
	// update existing member or create new one if it does not exist
	@PutMapping("/groups/{groupId}/members/{id}")
	MemberGetDto replaceMember(@RequestBody MemberPostDto newMember, @PathVariable Long groupId, @PathVariable Long id) {
		Country country = countryRepository.findById(newMember.getCountryId()).orElseThrow(() -> new ItemNotFoundException(Country.class.getName(), newMember.getCountryId()));
		return memberRepository.findById(id).map(member -> {
			member.setFirstName(newMember.getFirstName());
			member.setLastName(newMember.getLastName());
			member.setCountry(country);
			return mapstructMapper.memberToMemberGetDto(memberRepository.save(member));
		}).orElseGet(() -> {
			Member createdMember = new Member(newMember.getFirstName(), newMember.getLastName(), country);
			createdMember.setMusicGroup(groupRepository.findById(groupId).orElseThrow(() -> new ItemNotFoundException(MusicGroup.class.getName(), id)));
			return mapstructMapper.memberToMemberGetDto(memberRepository.save(createdMember));
		});
	}

	@DeleteMapping("/members/{id}")
	void deleteMember(@PathVariable Long id) {
		memberRepository.deleteById(id);
	}

}
