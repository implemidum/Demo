package com.implemidum.music.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.implemidum.music.data.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
