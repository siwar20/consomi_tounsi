package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="T_CMD_ITEM")
public class CommandItem implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	private int id;
	
	private int quantity;
	
	private double total;
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double t) {
		this.total = t;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public Command getCommand() {
		return command;
	}


	public void setCommand(Command command) {
		this.command = command;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@ManyToOne()
	@JoinColumn(name="prod_id", referencedColumnName = "product_id")  
	private Product product;
	
	
	public CommandItem(int quantity, float total, Product product, Command command) {
		super();
		this.quantity = quantity;
		this.total = total;
		this.product = product;
		this.command = command;
	}


	public CommandItem(int id, int quantity, float total, Product product, Command command) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.total = total;
		this.product = product;
		this.command = command;
	}


	public CommandItem() {
		super();
		// TODO Auto-generated constructor stub
	}


	@ManyToOne()
	@JoinColumn(name="cmd_id", referencedColumnName = "id")  
	private Command command;
}
