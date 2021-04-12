package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="T_COMMAND")
public class Command implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(mappedBy="command", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private List<CommandItem> items = new ArrayList<CommandItem>();
	
	@ManyToOne
	@JoinColumn(name="usr_id", referencedColumnName = "id")
	@JsonIgnore
	private User customer;
	
	
	private Date date;
	
	private double total;
	
	private boolean canceled = false;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private PaymentType paymentType;

	@JsonIgnore
	public CommandItem[] getAllItems()
	{
		CommandItem[] a = new CommandItem[50];
		return (CommandItem[]) new ArrayList<>(getItems()).toArray(a);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<CommandItem> getItems() {
		return items;
	}

	public void setItems(List<CommandItem> items) {
		this.items = items;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total2) {
		this.total = total2;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Command(List<CommandItem> items, User customer, Date date, float total, PaymentType paymentType) {
		super();
		this.items = items;
		this.customer = customer;
		this.date = date;
		this.total = total;
		this.paymentType = paymentType;
	}

	public Command(int id, List<CommandItem> items, User customer, Date date, float total, PaymentType paymentType) {
		super();
		this.id = id;
		this.items = items;
		this.customer = customer;
		this.date = date;
		this.total = total;
		this.paymentType = paymentType;
	}

	public Command() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean getCanceled() {
		return canceled;
	}

	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}
	
}

