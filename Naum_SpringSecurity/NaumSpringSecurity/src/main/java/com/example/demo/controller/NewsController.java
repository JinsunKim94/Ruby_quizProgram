package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.MemberVO;
import com.example.demo.entity.NewsArticleVO;
import com.example.demo.entity.NewsReplyVO;
import com.example.demo.entity.MemberVO;
import com.example.demo.service.NewsArticleService;
import com.example.demo.service.NewsReplyService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/news")
public class NewsController {

	@Autowired
	NewsArticleService newsArticleService;
	
	@Autowired
	NewsReplyService newsReplyService;

	@RequestMapping("")
	String newsHome(Model model, HttpServletRequest request,
			@RequestParam(value = "cat", required = false) String category,
			@RequestParam(value = "log", required = false) String logMsg) {
		if (category != null && !category.equals("")) {
			model.addAttribute("category", category);
			model.addAttribute("newsArticleList", newsArticleService.findByCategory(category));
			log.info(newsArticleService.findByCategory(category).toString());
		} else {
			model.addAttribute("category", "Ż�𴺽� Ȩ");
			model.addAttribute("newsArticleList", newsArticleService.findAll());
			log.info(newsArticleService.findAll().toString());
		}

		model.addAttribute("user", MemberVO.builder().build());
		log.info(logMsg);
		if (logMsg != null) {
			if (logMsg.equals("loginFail")) {
				model.addAttribute("logMsg", "���̵�� �н����带 Ȯ���ϼ���.");
			} else if (logMsg.equals("logout")) {
				model.addAttribute("logMsg", "�α׾ƿ��Ǿ����ϴ�.");
			}
		}
		return "news/index";
	}

//		@RequestMapping(path="add", method= RequestMethod.GET)
	@GetMapping("add")
	String addNews(Model model) {
		model.addAttribute("newsArticle",
				NewsArticleVO.builder()
				.build());
			return "news/add";
	}

	@PostMapping("add")
	String addNewsPage(Model model, @ModelAttribute NewsArticleVO newsArticle) {
		log.info(newsArticle.toString());
		newsArticleService.save(newsArticle);
		return "redirect:/news";
	}

	@RequestMapping("modify")
	String modifyNews(Model model, @RequestParam(value = "idx") Long idx) {
		log.info("�����Ͻðڽ��ϱ�?" + idx.toString());
		NewsArticleVO newsArticle = newsArticleService.findById(idx); // ����� ������ �� ������ �´�.
		model.addAttribute("newsArticle", newsArticle);
		return "news/add";
	}

	@RequestMapping("delete")
	String deleteNews(Model model, @RequestParam(value = "idx") long idx) {
		log.info("������ �����Ͻðڽ��ϱ�?");
		newsArticleService.deleteById(idx);
		return "redirect:/news";

	}

	@RequestMapping("detail2")
	String newsDetail(Model model, 
			@RequestParam("idx") Long idx) {
		if (idx != null) {
			log.info(idx.toString());
			model.addAttribute("msgName", idx);
			NewsArticleVO newsArticle = newsArticleService.findById(idx);
			if (newsArticle != null) {
				log.info(newsArticle.toString());
				model.addAttribute("newsArticle", newsArticle);
			}
			NewsReplyVO newsReply = NewsReplyVO.builder().build();
			model.addAttribute("newsReply", newsReply);
		}
		return "news/detail";

	}
	
	@PostMapping("reply/add")
	String addReply(Model model, Long newsArticleId, @ModelAttribute NewsReplyVO newsReply) {
	log.info(newsArticleId + ":" + newsReply.toString());
	
	NewsArticleVO newsArticle = newsArticleService.findById(newsArticleId);
	newsArticle.getReplies().add(newsReply);
	newsArticleService.save(newsArticle);
	return "redirect:/news/detail2?idx="+newsArticleId;
	}
	
	@RequestMapping("reply/modify")
	String modifyReply(Model model, 
			@RequestParam(value = "newsArticleId") Long newsArticleId,
			@RequestParam(value = "idx") Long idx) {
		log.info("�����Ͻðڽ��ϱ�?" + idx.toString());
		NewsArticleVO newsArticle = newsArticleService.findById(newsArticleId);
		NewsReplyVO newsReply = newsReplyService.findById(idx); // ����� ������ �� ������ �´�.
		model.addAttribute("newsArticle", newsArticle);
		model.addAttribute("newsReply", newsReply);
		return "news/modify";
	}
	
	@PostMapping("reply/modify")
	String addNewsReply(Model model,
			@RequestParam(value = "newsArticleId") long newsArticleId,
			@ModelAttribute NewsReplyVO newsReply) {
		NewsArticleVO newsArticle = newsArticleService.findById(newsArticleId);
		log.info(newsArticle.toString());
		newsReplyService.save(newsReply);
		return "redirect:/news/detail2?idx="+newsArticleId;
	}
	
	@RequestMapping("reply/delete")
	String deleteReply(Model model, @RequestParam(value = "idx") long idx, 
									@RequestParam(value = "newsArticleId") long newsArticleId) {
		NewsArticleVO newsArticle = newsArticleService.findById(newsArticleId);
		log.info(newsArticle.toString());
		log.info("������ �����Ͻðڽ��ϱ�?");
		newsReplyService.deleteById(idx);
		return "redirect:/news/detail2?idx="+newsArticleId;
	}
}