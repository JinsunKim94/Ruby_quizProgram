package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing  //Jpa�� Ȱ���� Auditing ����� Ȱ��ȭ / Ư���� ����ڰ� ���ڴٰ� ����
@EnableJpaRepositories
public class NaumSpringSecurityApplication {

	public static void main(String[] args) { //���� �ż��� - �� ������Ʈ ������ �� ���� ���� �۵��ؼ� �ٸ� ��ɵ��� �θ���.
		SpringApplication.run(NaumSpringSecurityApplication.class, args);
		
	}

}
