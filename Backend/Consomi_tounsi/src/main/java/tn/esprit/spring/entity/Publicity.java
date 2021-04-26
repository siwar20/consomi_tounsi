package tn.esprit.spring.entity;

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
@Table(name="T_PUBLICITY")
public class Publicity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	@Column(name="Pub_id")
	private int id;
	@Column(name="pub_cible")
	private String cible;
	@Temporal(TemporalType.DATE)
	private Date Start_date;
	@Temporal(TemporalType.DATE)
	private Date End_date;
	public Publicity(int id, String cible, Date start_date, Date end_date) {
		super();
		this.id = id;
		this.cible = cible;
		Start_date = start_date;
		End_date = end_date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCible() {
		return cible;
	}
	public void setCible(String cible) {
		this.cible = cible;
	}
	public Date getStart_date() {
		return Start_date;
	}
	public void setStart_date(Date start_date) {
		Start_date = start_date;
	}
	public Date getEnd_date() {
		return End_date;
	}
	public void setEnd_date(Date end_date) {
		End_date = end_date;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((End_date == null) ? 0 : End_date.hashCode());
		result = prime * result + ((Start_date == null) ? 0 : Start_date.hashCode());
		result = prime * result + ((cible == null) ? 0 : cible.hashCode());
		result = prime * result + id;
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
		Publicity other = (Publicity) obj;
		if (End_date == null) {
			if (other.End_date != null)
				return false;
		} else if (!End_date.equals(other.End_date))
			return false;
		if (Start_date == null) {
			if (other.Start_date != null)
				return false;
		} else if (!Start_date.equals(other.Start_date))
			return false;
		if (cible == null) {
			if (other.cible != null)
				return false;
		} else if (!cible.equals(other.cible))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Publicity [id=" + id + ", cible=" + cible + ", Start_date=" + Start_date + ", End_date=" + End_date
				+ "]";
	}
	
	
	
	

}
