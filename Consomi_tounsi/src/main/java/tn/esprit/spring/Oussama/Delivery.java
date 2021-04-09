package tn.esprit.spring.Oussama;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="T_DELIVERY")
public class Delivery implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	@Column(name="delivery_id")
	private int id;
	@Temporal (TemporalType.DATE)
	private Date delivery_date;
	@Column(name="delivery_status")
	private String status;
	@Column(name="delivery_price")
	private double price ;
	@Column(name = "moyen_de_transport")
	private String moyenDeTransport;
	private float distance;
	
	@ManyToOne
	delivery_man delivery_man;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="delivery")
	private List<orders> orders;
	
	
	
	

}
