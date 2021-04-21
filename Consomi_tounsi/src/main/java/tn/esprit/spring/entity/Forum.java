package tn.esprit.spring.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

	@Entity
	@Table(name="forum")
	@AllArgsConstructor
	@Data
	
	public class Forum {
		
	@Id
	@Column(name = "id")
	@GeneratedValue
	private Long id;
	private String subject;
	private int likes;

	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="forum")	private List<Forumdetail> details;
	public Forum() {
	        
	}
	public Forum(String subject,int likes) {
		this.subject=subject;
		this.likes=likes;
	}
	
		
		
	public List<Forumdetail> getDetails() {
		return details;
	}
	
	public void setDetails(List<Forumdetail> details) {
		this.details = details;
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
	public int getLikes() {
		// TODO Auto-generated method stub
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	

}
