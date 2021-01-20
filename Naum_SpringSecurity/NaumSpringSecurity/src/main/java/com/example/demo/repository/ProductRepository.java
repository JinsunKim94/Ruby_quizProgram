package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ProductVO;

public interface ProductRepository extends JpaRepository<ProductVO, Long>{
	

	List<ProductVO> findByProductCategory(String category);

}
