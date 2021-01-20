package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor //args = ��������
@Builder
	@Entity(name="user_role")  //����� ���̺��� �̸�
	public class MemberRole {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		long id;  //�÷����̹Ƿ� ������̼� �޾��ش�.
		@Column  //�̸��� �ٸ��� �÷� �ֳ����̼ǿ��� ���氡��
		String roleName;
		
}
