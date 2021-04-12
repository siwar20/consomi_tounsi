package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "T_RAYON")
public class Rayon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Rayon_id")
	private Long id;

	@Column(name = "Rayon_Quantity")
	private int Quantity;

	@Enumerated(EnumType.STRING)
	RayonType type;

	@Column(name = "Max")
	private int Max;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "rayon")
	private List<Product> product;

	public Rayon(int max) {
		super();
		Max = max;
	}

	public Rayon() {
		super();
	}

	public Rayon(List<Product> product) {
		super();
		this.product = product;
	}

	public Rayon(Long id, int quantity, tn.esprit.spring.entity.RayonType type) {
		super();
		this.id = id;
		Quantity = quantity;
		this.type = type;
	}

	public int getMax() {
		return Max;
	}

	public void setMax(int max) {
		Max = max;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public RayonType getType() {
		return type;
	}

	public void setType(RayonType type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Max;
		result = prime * result + Quantity;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
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
		Rayon other = (Rayon) obj;
		if (Max != other.Max)
			return false;
		if (Quantity != other.Quantity)
			return false;
		if (type != other.type)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Rayon [id=" + id + ", Quantity=" + Quantity + ", Type=" + type + ", Max=" + Max + ", product=" + product
				+ "]";
	}

}
