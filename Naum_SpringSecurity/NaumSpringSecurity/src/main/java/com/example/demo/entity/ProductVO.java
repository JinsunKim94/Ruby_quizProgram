package com.example.demo.entity;

	import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
	import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor //args = ��������
@Builder
	@Entity(name="product")  //���̺��� �̸�
	public class ProductVO {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		long id;  //�÷����̹Ƿ� ������̼� �޾��ش�.
		@Column  //�̸��� �ٸ��� �÷� �ֳ����̼ǿ��� ���氡��
		String productName;
		@Column
		String productInfo;
		@Column
		String sellerName;
		@Column
		String sellerEmail;
		@Column
		String productCategory;
		
		
}