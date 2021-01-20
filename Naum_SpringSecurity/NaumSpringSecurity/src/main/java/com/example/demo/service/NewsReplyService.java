package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.NewsArticleVO;
import com.example.demo.entity.NewsReplyVO;
import com.example.demo.repository.NewsReplyRepository;


@Service
public class NewsReplyService {
	@Autowired
	NewsReplyRepository newsReplyRepository;
	
	public List<NewsReplyVO> findAll(){
		return newsReplyRepository.findAll();
	}
	
	public NewsReplyVO findById(Long idx) {
		try {
		Optional<NewsReplyVO> vo = newsReplyRepository.findById(idx);
		return vo.get();
	}catch(Exception e) {
		return null;
	}
}		
	public void deleteById(long idx) {
		 newsReplyRepository.deleteById(idx);
	}
	
	public NewsReplyVO save(NewsReplyVO newsReply) {
		// TODO Auto-generated method stub
		return newsReplyRepository.save(newsReply);
		
	}

}