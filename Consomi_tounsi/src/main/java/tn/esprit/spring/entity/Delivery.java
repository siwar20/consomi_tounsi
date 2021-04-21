package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
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
	private Set<orders> orders;
	
	
	public Delivery() {
		super();
	}

	

	public Delivery(int id, Date delivery_date, String status, double price, String moyenDeTransport, float distance,
			tn.esprit.spring.entity.delivery_man delivery_man, Set<tn.esprit.spring.entity.orders> orders) {
		super();
		this.id = id;
		this.delivery_date = delivery_date;
		this.status = status;
		this.price = price;
		this.moyenDeTransport = moyenDeTransport;
		this.distance = distance;
		this.delivery_man = delivery_man;
		this.orders = orders;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDelivery_date() {
		return delivery_date;
	}

	public void setDelivery_date(Date delivery_date) {
		this.delivery_date = delivery_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getMoyenDeTransport() {
		return moyenDeTransport;
	}

	public void setMoyenDeTransport(String moyenDeTransport) {
		this.moyenDeTransport = moyenDeTransport;
	}

	public float getDistance() {
		return distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}

	public delivery_man getDelivery_man() {
		return delivery_man;
	}

	public void setDelivery_man(delivery_man delivery_man) {
		this.delivery_man = delivery_man;
	}

	public List<orders> getOrders() {
		return (List<tn.esprit.spring.entity.orders>) orders;
	}

	public void setOrders(List<orders> orders) {
		this.orders = (Set<tn.esprit.spring.entity.orders>) orders;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((delivery_date == null) ? 0 : delivery_date.hashCode());
		result = prime * result + ((delivery_man == null) ? 0 : delivery_man.hashCode());
		result = prime * result + Float.floatToIntBits(distance);
		result = prime * result + id;
		result = prime * result + ((moyenDeTransport == null) ? 0 : moyenDeTransport.hashCode());
		result = prime * result + ((orders == null) ? 0 : orders.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Delivery other = (Delivery) obj;
		if (delivery_date == null) {
			if (other.delivery_date != null)
				return false;
		} else if (!delivery_date.equals(other.delivery_date))
			return false;
		if (delivery_man == null) {
			if (other.delivery_man != null)
				return false;
		} else if (!delivery_man.equals(other.delivery_man))
			return false;
		if (Float.floatToIntBits(distance) != Float.floatToIntBits(other.distance))
			return false;
		if (id != other.id)
			return false;
		if (moyenDeTransport == null) {
			if (other.moyenDeTransport != null)
				return false;
		} else if (!moyenDeTransport.equals(other.moyenDeTransport))
			return false;
		if (orders == null) {
			if (other.orders != null)
				return false;
		} else if (!orders.equals(other.orders))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Delivery [id=" + id + ", delivery_date=" + delivery_date + ", status=" + status + ", price=" + price
				+ ", moyenDeTransport=" + moyenDeTransport + ", distance=" + distance + ", delivery_man=" + delivery_man
				+ ", orders=" + orders + "]";
	}
	
	
	
	

}
