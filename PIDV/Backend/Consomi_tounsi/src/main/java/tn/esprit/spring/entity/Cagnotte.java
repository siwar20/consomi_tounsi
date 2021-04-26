package tn.esprit.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Cagnotte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDon;
	private String owner;
	private double money;
	private Long idEvent ;
	public Cagnotte(String owner, double money, Long idEvent) {
		super();
		this.owner = owner;
		this.money = money;
		this.idEvent = idEvent;
	}
	public Cagnotte() {
		
	}
	public Long getIdDon() {
		return idDon;
	}
	public void setIdDon(Long idDon) {
		this.idDon = idDon;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public Long getIdEvent() {
		return idEvent;
	}
	public void setIdEvent(Long idEvent) {
		this.idEvent = idEvent;
	}
	
}