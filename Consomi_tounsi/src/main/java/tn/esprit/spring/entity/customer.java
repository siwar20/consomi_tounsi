package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="T_Customer")
public class customer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;
	private String lastname;
	private String Adress;
	@Column(length=8)
	private long tel;
	
	@Temporal(TemporalType.DATE)
	private Date birth_date;
	
	
	@OneToMany (cascade = CascadeType.ALL, mappedBy="customer")
	private Set<tn.esprit.spring.Oussama.orders> orders;
	
	@OneToMany (cascade = CascadeType.ALL, mappedBy="customer")
	private Set<donations> donations;

	public customer(Integer id, String name, String lastname, String adress, long tel, Date birth_date) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		Adress = adress;
		this.tel = tel;
		this.birth_date = birth_date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAdress() {
		return Adress;
	}

	public void setAdress(String adress) {
		Adress = adress;
	}

	public long getTel() {
		return tel;
	}

	public void setTel(long tel) {
		this.tel = tel;
	}

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		customer other = (customer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	
	}

	@Override
	public String toString() {
		return "customer [id=" + id + ", name=" + name + ", lastname=" + lastname + ", Adress=" + Adress + ", tel="
				+ tel + ", birth_date=" + birth_date + "]";
	}
	
	
	
	

}
