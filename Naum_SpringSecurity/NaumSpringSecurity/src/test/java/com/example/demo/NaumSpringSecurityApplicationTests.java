package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.MemberRole;
import com.example.demo.entity.MemberVO;
import com.example.demo.entity.NewsArticleVO;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.NewsArticleRepository;
import com.example.demo.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class NaumSpringSecurityApplicationTests {

	@Autowired
	MemberService memberService;
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	NewsArticleRepository newsArticleRepository;
	@Test
	void insertNewsArticleTest() {
		NewsArticleVO newsArticle = NewsArticleVO.builder()
				.title("test")
				.category("½ºÆ÷Ã÷")
				.contents("test")
				.build();
		newsArticleRepository.save(newsArticle);
	}
	@Disabled
	@Test
	void insertTest() {
		for(int i = 0; i < 100; i++) {
			MemberVO member = MemberVO.builder()
					.userId("user"+i)
					.password("1234")
					.email("user"+i+"@gmail.com")
					.build();
			List<MemberRole> roles = new ArrayList<MemberRole>();
			MemberRole role = MemberRole.builder()
					.build();
			if(i<=80) {
				role.setRoleName("USER");
			}else if(i<=90) {
				role.setRoleName("SELLER");
			}else if(i<=95){
				role.setRoleName("ADMIN");
			}else {
				role.setRoleName("USER");
				roles.add(role);
				role = MemberRole.builder().build();
				role.setRoleName("SELLER");
			}
			roles.add(role);
			member.setRoles(roles);
			memberService.save(member);
			}
		}
	}


