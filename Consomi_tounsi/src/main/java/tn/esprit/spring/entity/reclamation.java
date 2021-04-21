package tn.esprit.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.spring.entity.paiments;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table (name="T_RECLAMATION")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
	private String subject;
	private String email;
	public reclamation() {
		super();
	}
	public reclamation(int id, Date reclamation_date, String status, String subject, String email) {
		super();
		this.id = id;
		this.reclamation_date = reclamation_date;
		this.status = status;
		this.subject = subject;
		this.email = email;
	}
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((reclamation_date == null) ? 0 : reclamation_date.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
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
		reclamation other = (reclamation) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (reclamation_date == null) {
			if (other.reclamation_date != null)
				return false;
		} else if (!reclamation_date.equals(other.reclamation_date))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "reclamation [id=" + id + ", reclamation_date=" + reclamation_date + ", status=" + status + ", subject="
				+ subject + ", email=" + email + "]";
	}


}
