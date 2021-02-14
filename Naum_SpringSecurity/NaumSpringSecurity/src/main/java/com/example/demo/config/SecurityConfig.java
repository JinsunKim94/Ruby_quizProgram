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

@Configuration //스프링의 환경 설정과 관련된 파일이다라고 의미하는 어노테이션(데이타 소스를 던져주는 @Bean 설정이 필요)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	MemberService memberService;
	
	@Override
	public void configure(WebSecurity web) throws Exception{  //웹서비스 전체에서 보안을 걸어줄지 말지 권한을 어떻게 줄지에 관한 소스코드
		web.ignoring().antMatchers("/css/**", "/script/**", "/image/**", "/img/**", "/fonts/**", "lib/**"); //이 경로로 시작하는 건 무시하고 다 열어줘라
	}

	@Override
	public void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/user/seller/**").hasRole("SELLER")
		.antMatchers("/news/**").authenticated() //로그인만 하면 통과
		.antMatchers("/user/myinfo").hasRole("USER")  //내 정보
		.antMatchers("/**").permitAll()
	.and()
		.formLogin()
		.loginPage("/user/login") //로그인 페이지는 얘다
		.defaultSuccessUrl("/user/login/result")  //로그인 성공하면 이 페이지로 이동
		.permitAll() //로그인 폼은 모두에게 허가
		//로그인이나 권한관련해서 간단하게 끝남.
	.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
		.logoutSuccessUrl("/user/logout/result")
		.invalidateHttpSession(true)
	.and()
		.exceptionHandling().accessDeniedPage("/user/denied");  //로그아웃은 세션 자체를 무효화시킴.완전히 지운다.
	}
	
	@Bean // 단일 인스턴스를 등록해준다.
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
