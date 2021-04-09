package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class paiments implements Serializable {

	public paiments() {
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="paiement_Type")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	@Column (name="client_id")
	 private String client_id;
	
	@OneToOne(mappedBy="Paiments")
	private tn.esprit.spring.Oussama.orders orders;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
}