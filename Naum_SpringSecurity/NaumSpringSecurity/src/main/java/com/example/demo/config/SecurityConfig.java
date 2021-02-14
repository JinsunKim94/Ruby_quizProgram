package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.demo.service.MemberService;

@Configuration //�������� ȯ�� ������ ���õ� �����̴ٶ�� �ǹ��ϴ� ������̼�(����Ÿ �ҽ��� �����ִ� @Bean ������ �ʿ�)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	MemberService memberService;
	
	@Override
	public void configure(WebSecurity web) throws Exception{  //������ ��ü���� ������ �ɾ����� ���� ������ ��� ������ ���� �ҽ��ڵ�
		web.ignoring().antMatchers("/css/**", "/script/**", "/image/**", "/img/**", "/fonts/**", "lib/**"); //�� ��η� �����ϴ� �� �����ϰ� �� �������
	}

	@Override
	public void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/user/seller/**").hasRole("SELLER")
		.antMatchers("/news/**").authenticated() //�α��θ� �ϸ� ���
		.antMatchers("/user/myinfo").hasRole("USER")  //�� ����
		.antMatchers("/**").permitAll()
	.and()
		.formLogin()
		.loginPage("/user/login") //�α��� �������� ���
		.defaultSuccessUrl("/user/login/result")  //�α��� �����ϸ� �� �������� �̵�
		.permitAll() //�α��� ���� ��ο��� �㰡
		//�α����̳� ���Ѱ����ؼ� �����ϰ� ����.
	.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
		.logoutSuccessUrl("/user/logout/result")
		.invalidateHttpSession(true)
	.and()
		.exceptionHandling().accessDeniedPage("/user/denied");  //�α׾ƿ��� ���� ��ü�� ��ȿȭ��Ŵ.������ �����.
	}
	
	@Bean // ���� �ν��Ͻ��� ������ش�.
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) 
			throws Exception{
		auth.userDetailsService(memberService)
		.passwordEncoder(passwordEncoder());
	}
	
}
