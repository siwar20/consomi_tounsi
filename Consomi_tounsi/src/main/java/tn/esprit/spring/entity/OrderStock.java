package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_ORDERSTOCK")
public class OrderStock implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy= GenerationType.AUTO)
	@Column(name="OrderStock_id")
	private Long id;
	@Column(name="OrderStock_Name")
	private String Name;
	@Column(name="Order_Quantity")
	private int Quantity;
	
	
	public OrderStock(int quantity) {
		super();
		Quantity = quantity;
	}

	@ManyToOne
	Stocks stocks;

	public OrderStock() {
		super();
	}

	public OrderStock(Long id, String name, Stocks stocks) {
		super();
		this.id = id;
		Name = name;
		this.stocks = stocks;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Stocks getStocks() {
		return stocks;
	}

	public void setStocks(Stocks stocks) {
		this.stocks = stocks;
	}
	

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + Quantity;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((stocks == null) ? 0 : stocks.hashCode());
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
		OrderStock other = (OrderStock) obj;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		if (Quantity != other.Quantity)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (stocks == null) {
			if (other.stocks != null)
				return false;
		} else if (!stocks.equals(other.stocks))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderStock [id=" + id + ", Name=" + Name + ", Quantity=" + Quantity + ", stocks=" + stocks + "]";
	}
	
	
	

}
