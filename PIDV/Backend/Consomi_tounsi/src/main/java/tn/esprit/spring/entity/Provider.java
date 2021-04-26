package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="T_PROVIDER")
public class Provider implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	@Column(name="provider_id")
	private int id;
	
	@Column(name="Provider_Adresse")
	private String Adress;
	@Column(name="provider_num" , length=8)
	private long telnum;
	@Column(name="Provider_E_mail")
	private String email;
	public Provider(int id, String adress, long telnum, String email) {
		super();
		this.id = id;
		Adress = adress;
		this.telnum = telnum;
		this.email = email;
	}
	@OneToMany (cascade = CascadeType.ALL, mappedBy="provider")
	private Set<Product> Products;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdress() {
		return Adress;
	}
	public void setAdress(String adress) {
		Adress = adress;
	}
	public long getTelnum() {
		return telnum;
	}
	public void setTelnum(long telnum) {
		this.telnum = telnum;
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
		result = prime * result + ((Adress == null) ? 0 : Adress.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + (int) (telnum ^ (telnum >>> 32));
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
		Provider other = (Provider) obj;
		if (Adress == null) {
			if (other.Adress != null)
				return false;
		} else if (!Adress.equals(other.Adress))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (telnum != other.telnum)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Provider [id=" + id + ", Adress=" + Adress + ", telnum=" + telnum + ", email=" + email + "]";
	}

	
	

}
