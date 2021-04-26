package tn.esprit.spring.payload;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommandReq {
	
	public long getIdUser() {
		return idUser;
	}
	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public List<CmdItemReq> getItems() {
		return items;
	}
	public void setItems(List<CmdItemReq> items) {
		this.items = items;
	}
	private long idUser;
	private Date date;
	public CommandReq(long idUser, Date date, String paymentType, List<CmdItemReq> items) {
		super();
		this.idUser = idUser;
		this.date = date;
		this.paymentType = paymentType;
		this.items = items;
	}
	public CommandReq() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String paymentType;
	private List<CmdItemReq> items = new ArrayList<>();

}
