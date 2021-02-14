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
								.getAuthentication(); // �α����ϸ� ��� ���ǿ� �� ������ ���µ� �װŸ� �������� �޾ƿ� �� �ִ�.
		
		if(auth == null //�������� ��ü�� ����
				|| !auth.isAuthenticated() //���ε� �α����� ���ߴ�.
				|| auth.getPrincipal().toString().compareTo("anonymousUser")==0) {  //�α��� �ߴµ� �װ� toString��ȯ�ؼ� "anonymousUser"�� ��
			return Optional.of("anonymousUser");  //�͸� ����ڸ� anonymousUser�� ���, �ƴ϶�� ������ ���� �����̸� �޾ƿ´�.
		}
		return Optional.of(
				((User)auth.getPrincipal()).getUsername() //�α��εǾ� ������ �α��εǾ��ִ� ����� �̸��� ������ �ƴϸ� anonymousUser
				);
	} 

}
