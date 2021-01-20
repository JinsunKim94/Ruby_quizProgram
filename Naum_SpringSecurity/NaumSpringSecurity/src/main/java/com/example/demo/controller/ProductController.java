package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.ProductVO;
import com.example.demo.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller 
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@RequestMapping("")
	public String index() {
		return "product/index";
	}

	@GetMapping("/seller")
	public String selling(Model model) {
		model.addAttribute("product", ProductVO.builder().build());
		return "product/seller";
	}
	
	@GetMapping("/product/seller/add")
	String addNews(Model model) {
		model.addAttribute("product",
				ProductVO.builder()
				.build());
			return "product/index";
	}

	@PostMapping("/product/seller/add")
	String addNewsPage(Model model, @ModelAttribute ProductVO product) {
		//log.info(product.toString());
		productService.save(product);
		return "redirect:/product";
	}
}