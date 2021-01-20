package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.MemberVO;
import com.example.demo.entity.NewsArticleVO;
import com.example.demo.entity.ProductVO;
import com.example.demo.service.MemberService;
import com.example.demo.service.ProductService;

@Controller // 매핑이 없으면 포트번호 옆에 다른 매핑들로 시작가능
public class MemberController {

	@Autowired
	MemberService memberService;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/user/login")
	public String loginPage(Model model) {
		model.addAttribute("user", MemberVO.builder().build());
		return "login";
	}

	@GetMapping("/user/login/result")
	public String loginSuccessPage(Model model) {
		return "loginSuccess";
	}

	@GetMapping("/user/logout/result")
	public String logoutSuccessPage(Model model) {
		return "logout";
	}

	@GetMapping("/user/denied")
	public String deniedPage(Model model) {
		return "403";
	}

	@GetMapping("/user/join")
	public String joinPage(Model model) {
		model.addAttribute("user",MemberVO.builder().build());
		return "join";
	}
	
	@PostMapping("/user/join")
	public String join(MemberVO memberVO) {
		//Log.info(memberVO.toString());
		memberService.save(memberVO);
		return "redirect:/user/login";
	}
	
	@GetMapping("/user/seller/index")
	public String submit(Model model) {
		return "redirect:/product/index";
	}
}