package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing  //Jpa를 활용한 Auditing 기능을 활성화 / 특정한 사용자가 쓰겠다고 선언
@EnableJpaRepositories
public class NaumSpringSecurityApplication {

	public static void main(String[] args) { //메인 매서드 - 이 프로젝트 시작할 때 가장 먼저 작동해서 다른 기능들을 부른다.
		SpringApplication.run(NaumSpringSecurityApplication.class, args);
		
	}

}
