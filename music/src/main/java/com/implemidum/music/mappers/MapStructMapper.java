package com.implemidum.music.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.implemidum.music.data.Album;
import com.implemidum.music.data.Country;
import com.implemidum.music.data.Member;
import com.implemidum.music.data.MusicGroup;
import com.implemidum.music.data.Song;
import com.implemidum.music.dtos.AlbumGetDto;
import com.implemidum.music.dtos.AlbumPostDto;
import com.implemidum.music.dtos.CountryGetDto;
import com.implemidum.music.dtos.CountrySelectDto;
import com.implemidum.music.dtos.MemberGetDto;
import com.implemidum.music.dtos.MusicGroupGetDto;
import com.implemidum.music.dtos.MusicGroupPostDto;
import com.implemidum.music.dtos.MusicGroupSearchDto;
import com.implemidum.music.dtos.SongGetDto;
import com.implemidum.music.dtos.SongPostDto;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
	
	/**
	 * MusicGroup Mappings
	 */
	MusicGroupGetDto musicGroupToMusicGroupGetDto(MusicGroup group);
	
	List<MusicGroupGetDto> allMusicGroupToMusicGroupGetDto(List<MusicGroup> group);
	
	MusicGroup musicGroupPostDtoToMusicGroup(MusicGroupPostDto group);
	
	MusicGroupSearchDto musicGroupToMusicGroupSearchDto(MusicGroup group);
	
	List<MusicGroupSearchDto> listMusicGroupToMusicGroupSearchDto(List<MusicGroup> group);
	
	/**
	 * Member Mappings
	 */
	@Mapping(target="id", source="id")
	@Mapping(target="firstName", source="firstName")
	@Mapping(target="lastName", source="lastName")
	@Mapping(target="country", source="country.name")
	@Mapping(target="countryId", source="country.id")
	MemberGetDto memberToMemberGetDto(Member Member);
	
	List<MemberGetDto> listMemberToListMemberGetDto(List<Member> member);
	
	
	/**
	 * Album Mappings
	 */
	@Mapping(target="group", source="musicGroup.name")
	AlbumGetDto albumToAlbumGetDto(Album album);
	
	List<AlbumGetDto> listAlbumToListAlbumGetDto(List<Album> album);
	
	@Mapping(target="id", source="id")
	@Mapping(target="title", source="title")
    @Mapping(target="description", source="description")
	Album albumPostDtoToAlbum(AlbumPostDto album);
	
	/**
	 * Song Mappings
	 */
	SongGetDto songToSongGetDto(Song song);
	
	List<SongGetDto> listSongToListSongGetDto(List<Song> song);
	
	Song songPostDtoToSong(SongPostDto song);
	
	/**
	 * Country Mappings
	 */
	CountryGetDto countryToCountryGetDto(Country country);
	
	@Mapping(target="id", source="id")
	@Mapping(target="value", source="name")
	CountrySelectDto countryToCountrySelectDto(Country country);
	
	List<CountryGetDto> listCountryToListCountryGetDto(List<Country> countries);
	List<CountrySelectDto> listCountryToListCountrySelectDto(List<Country> countries);
}
