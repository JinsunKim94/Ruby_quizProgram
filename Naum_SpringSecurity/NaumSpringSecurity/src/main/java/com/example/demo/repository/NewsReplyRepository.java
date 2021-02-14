package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.NewsReplyVO;


public interface NewsReplyRepository extends JpaRepository<NewsReplyVO, Long>{
	
	List<NewsReplyVO> findById(String category);
	
	
}
