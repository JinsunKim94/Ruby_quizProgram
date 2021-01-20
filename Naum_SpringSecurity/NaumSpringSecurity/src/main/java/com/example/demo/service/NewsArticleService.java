package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.NewsArticleVO;
import com.example.demo.repository.NewsArticleRepository;

@Service
public class NewsArticleService {
	@Autowired
	NewsArticleRepository newsArticleRepository;
	
	public List<NewsArticleVO> findAll(){
		return newsArticleRepository.findAll();
	}
	
	public NewsArticleVO findById(Long idx) {
		try {
		Optional<NewsArticleVO> vo = newsArticleRepository.findById(idx);
		return vo.get();
	}catch(Exception e) {
		return null;
	}
}

	public List<NewsArticleVO> findByCategory(String category) {
		// TODO Auto-generated method stub
		return newsArticleRepository.findByCategory(category);
		
	}

	public NewsArticleVO save(NewsArticleVO newsArticle) {
		// TODO Auto-generated method stub
		return newsArticleRepository.save(newsArticle);
		
	}
	
	public void deleteById(Long idx) {
		 newsArticleRepository.deleteById(idx);
	}
}