package tn.esprit.spring.entity;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name="mots")
@AllArgsConstructor
@Data

public class Mots {
	
	@Id
	@Column(name = "id")
	private Long id;
	private String subject;
	

	public Mots(String subject, long id) {
		this.subject=subject;
		this.id=id;
		
	}
	
	public Mots() {
	        
	}
	
	
		
		
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	}
	
