package com.example.demo.config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class AuditorAwareImpl implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		Authentication auth = SecurityContextHolder
								.getContext()
								.getAuthentication(); // 로그인하면 기밀 세션에 내 정보가 담기는데 그거를 언제든지 받아올 수 있다.
		
		if(auth == null //인증정보 자체가 없다
				|| !auth.isAuthenticated() //뭐로도 로그인을 않했다.
				|| auth.getPrincipal().toString().compareTo("anonymousUser")==0) {  //로그인 했는데 그걸 toString변환해서 "anonymousUser"랑 비교
			return Optional.of("anonymousUser");  //익명 사용자면 anonymousUser를 출력, 아니라면 권한을 가진 유저이름 받아온다.
		}
		return Optional.of(
				((User)auth.getPrincipal()).getUsername() //로그인되어 있으면 로그인되어있는 사용자 이름이 나오고 아니면 anonymousUser
				);
	} 

}
