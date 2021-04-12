package tn.esprit.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Eventse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ; 
	private String name ;
	private String dateEvent ; 
	private double budget ;
	private String lieu ;
	public Eventse(Long id, String name, String dateEvent, double budget, String lieu) {
		super();
		this.id = id;
		this.name = name;
		this.dateEvent = dateEvent;
		this.budget = budget;
		this.lieu = lieu;
	}
	public Eventse () {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDateEvent() {
		return dateEvent;
	}
	public void setDateEvent(String dateEvent) {
		this.dateEvent = dateEvent;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	
}
