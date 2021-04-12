package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="T_Orders")
public class orders implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Orders_id;
	@Temporal(TemporalType.DATE)
	private Date order_date;
	
	@OneToOne
	private paiments Paiments;
	
	@ManyToOne
	delivery delivery;
	
	@ManyToOne
	customer customer;
	
	@ManyToOne
	Product Product;
	
	
	public orders(Integer orders_id, Date birth_date) {
		super();
		Orders_id = orders_id;
		this.order_date = birth_date;
	}

	public Integer getOrders_id() {
		return Orders_id;
	}

	public void setOrders_id(Integer orders_id) {
		Orders_id = orders_id;
	}

	public Date getBirth_date() {
		return order_date;
	}

	public void setBirth_date(Date birth_date) {
		this.order_date = birth_date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Orders_id == null) ? 0 : Orders_id.hashCode());
		result = prime * result + ((order_date == null) ? 0 : order_date.hashCode());
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
		orders other = (orders) obj;
		if (Orders_id == null) {
			if (other.Orders_id != null)
				return false;
		} else if (!Orders_id.equals(other.Orders_id))
			return false;
		if (order_date == null) {
			if (other.order_date != null)
				return false;
		} else if (!order_date.equals(other.order_date))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "orders [Orders_id=" + Orders_id + ", birth_date=" + order_date + "]";
	}
	
	
	
	

}
