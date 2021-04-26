package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="T_Orders")
public class orders implements Serializable {
	
private static final long serialVersionUID = 1L;
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer Orders_id;
@Temporal(TemporalType.DATE)
private Date order_date;
public float weight;
	
	@OneToOne
	private paiments Paiments;
	
	@ManyToOne
	Delivery delivery;
	
	@ManyToOne
    tn.esprit.spring.entity.customer customer;

    @ManyToOne
    tn.esprit.spring.entity.Product Product;

	
	
    public orders() {
		super();
	}

	public orders(Integer orders_id, Date order_date, float weight, paiments paiments, Delivery delivery,
			tn.esprit.spring.entity.customer customer, tn.esprit.spring.entity.Product product) {
		super();
		Orders_id = orders_id;
		this.order_date = order_date;
		this.weight = weight;
		Paiments = paiments;
		this.delivery = delivery;
		this.customer = customer;
		Product = product;
	}

	public Integer getOrders_id() {
		return Orders_id;
	}

	public void setOrders_id(Integer orders_id) {
		Orders_id = orders_id;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public paiments getPaiments() {
		return Paiments;
	}

	public void setPaiments(paiments paiments) {
		Paiments = paiments;
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	public tn.esprit.spring.entity.customer getCustomer() {
		return customer;
	}

	public void setCustomer(tn.esprit.spring.entity.customer customer) {
		this.customer = customer;
	}

	public tn.esprit.spring.entity.Product getProduct() {
		return Product;
	}

	public void setProduct(tn.esprit.spring.entity.Product product) {
		Product = product;
	}

	@Override
	public String toString() {
		return "orders [Orders_id=" + Orders_id + ", order_date=" + order_date + ", weight=" + weight + ", Paiments="
				+ Paiments + ", delivery=" + delivery + ", customer=" + customer + ", Product=" + Product + "]";
	}

    
    

}
