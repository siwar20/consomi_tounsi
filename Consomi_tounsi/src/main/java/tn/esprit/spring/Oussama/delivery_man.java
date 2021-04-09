package tn.esprit.spring.Oussama;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name="T_DELIVERY_MAN")
public class delivery_man implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	@Column(name="deliveryman_id")
	private int id;
	@Column(name="deliveryman_name")
	private String name ;
	@Column(name="deliveryman_lastname")
	private String lastname ;
	private double salaire;
	private double bonus;
	private double distance;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="delivery_man")
	private Set<Delivery> delivery;
	
	

}
