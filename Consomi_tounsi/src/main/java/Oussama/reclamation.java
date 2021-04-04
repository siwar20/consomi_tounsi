package Oussama;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name="T_RECLAMATION")

public class reclamation implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	@Column(name="reclamation_id")
	private int id;
	@Temporal (TemporalType.DATE)
	private Date reclamation_date;
	@Column(name="reclamation_status")
	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getReclamation_date() {
		return reclamation_date;
	}
	public void setReclamation_date(Date reclamation_date) {
		this.reclamation_date = reclamation_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public reclamation(int id, Date reclamation_date, String status) {
		super();
		this.id = id;
		this.reclamation_date = reclamation_date;
		this.status = status;
	}
	

	


}
