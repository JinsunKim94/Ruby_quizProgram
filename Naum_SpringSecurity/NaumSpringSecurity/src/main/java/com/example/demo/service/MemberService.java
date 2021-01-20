package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MemberRole;
import com.example.demo.entity.MemberVO;
import com.example.demo.repository.MemberRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class MemberService implements UserDetailsService {

	@Autowired
	MemberRepository memberRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException { //로그인할 때 사용함. UserDetail은 인증된(로그인된)사용자
		MemberVO member = memberRepository.findByUserId(username);  //member가 아이디랑 패스워드 role을 다 가지고 있다.
		List<MemberRole> roles = member.getRoles(); //roles는 List
		List<GrantedAuthority> authorities = new ArrayList<>();
		for(MemberRole role : roles) {
			authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
		}
		
		return new User(member.getUserId(), member.getPassword(), authorities);   //사용자 이름만 받아서 사용
		
	}

	public void save(MemberVO memberVO) {  //service에도 save기능
		BCryptPasswordEncoder passwordEncoder 
			= new BCryptPasswordEncoder();
		
		memberVO.setPassword(
				passwordEncoder.encode( //암호화 엔코딩
						memberVO.getPassword())); //저장하려는 친구의 패스워드
		
		
		memberRepository.save(memberVO);
	}
	
}
