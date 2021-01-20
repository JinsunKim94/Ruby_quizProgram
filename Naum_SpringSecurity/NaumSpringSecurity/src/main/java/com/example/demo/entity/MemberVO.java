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
@AllArgsConstructor //args = 연결인자
@Builder
	@Entity(name="user")  //통신할 테이블의 이름
	public class MemberVO {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		long id;  //컬럼들이므로 어노테이션 달아준다.
		@Column(name="user_id")  //이름이 다르면 컬럼 애너테이션에서 변경가능
		String userId;
		@Column
		String password;
		@Column
		String userName;
		@Column
		String email;

		@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
		@JoinColumn(name="uid")
		List<MemberRole> roles;
}
