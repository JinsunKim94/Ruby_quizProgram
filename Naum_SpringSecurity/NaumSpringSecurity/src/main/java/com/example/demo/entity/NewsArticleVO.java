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
@AllArgsConstructor //args = ��������
@Builder
@Entity(name="news_article")  //����� ���̺��� �̸�
@Audited  //����
	public class NewsArticleVO extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;  //�÷����̹Ƿ� ������̼� �޾��ش�.
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
