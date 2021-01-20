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
@AllArgsConstructor //args = 연결인자
@Builder
	@Entity(name="user_role")  //통신할 테이블의 이름
	public class MemberRole {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		long id;  //컬럼들이므로 어노테이션 달아준다.
		@Column  //이름이 다르면 컬럼 애너테이션에서 변경가능
		String roleName;
		
}
