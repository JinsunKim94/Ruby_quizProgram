package com.example.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass //맵핑용 부모 클래스 , @Entity를 임포트하면 바로 만들어버려서 안 쓴다.
@EntityListeners(value = {AuditingEntityListener.class}) //?
@Audited
public class BaseEntity { // id넣는 경우도 많다.
	
	@Column(updatable = false) //달아도 되고 안달아도 된다. 명시적인 역할
	@CreatedDate
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	LocalDateTime createdDate;
	
	@Column(updatable = false) //?
	@LastModifiedDate
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	LocalDateTime lastModifiedDate;
	
	@Column
	@CreatedBy
	String createdBy;
	
	@Column
	@LastModifiedBy
	String lastModifiedBy;
	
}
