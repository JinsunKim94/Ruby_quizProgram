package com.example.demo.entity;

import java.util.Collection;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor //args = 연결인자
@Builder
@Entity(name="news_article")  //통신할 테이블의 이름
@Audited  //감시
	public class NewsArticleVO extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;  //컬럼들이므로 어노테이션 달아준다.
	@Column
	String title;
	@Column
	String contents;
	@Column
	String author;
	@Column
	String category;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="news_article_id")
	Collection<NewsReplyVO> replies;
	
}
