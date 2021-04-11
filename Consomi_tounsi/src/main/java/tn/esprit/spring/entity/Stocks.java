package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "T_STOCKS")
public class Stocks implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "stock_id")
	private Long id;

	@Column(name = "stock_remaining_quantity")
	private int RemainingQuantity;

	@Column(name = "min")
	private int Min;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "stocks")
	private List<Product> product;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "stocks")
	private List<OrderStock> orderstocks;

	public Stocks() {
		super();
	}

	public Stocks(Long id, int stock_remaining_quantity, int min, List<Product> product, List<OrderStock> orderstocks) {
		super();
		this.id = id;
		this.RemainingQuantity = stock_remaining_quantity;
		// Min = min;
		this.product = product;
		this.orderstocks = orderstocks;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getStock_remaining_quantity() {
		return RemainingQuantity;
	}

	public void setStock_remaining_quantity(int stock_remaining_quantity) {
		this.RemainingQuantity = stock_remaining_quantity;
	}

	public int getMin() {
		return Min;
	}

	public void setMin(int min) {
		Min = min;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public List<OrderStock> getOrderstocks() {
		return orderstocks;
	}

	public void setOrderstocks(List<OrderStock> orderstocks) {
		this.orderstocks = orderstocks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Min;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((orderstocks == null) ? 0 : orderstocks.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + RemainingQuantity;
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
		Stocks other = (Stocks) obj;
		if (Min != other.Min)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (orderstocks == null) {
			if (other.orderstocks != null)
				return false;
		} else if (!orderstocks.equals(other.orderstocks))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (RemainingQuantity != other.RemainingQuantity)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Stocks [id=" + id + ", stock_remaining_quantity=" + RemainingQuantity + ", Min=" + Min + ", product="
				+ product + ", orderstocks=" + orderstocks + "]";
	}

}