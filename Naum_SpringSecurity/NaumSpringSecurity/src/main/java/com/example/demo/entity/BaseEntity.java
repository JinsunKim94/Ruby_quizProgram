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
@MappedSuperclass //���ο� �θ� Ŭ���� , @Entity�� ����Ʈ�ϸ� �ٷ� ���������� �� ����.
@EntityListeners(value = {AuditingEntityListener.class}) //?
@Audited
public class BaseEntity { // id�ִ� ��쵵 ����.
	
	@Column(updatable = false) //�޾Ƶ� �ǰ� �ȴ޾Ƶ� �ȴ�. ������� ����
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
