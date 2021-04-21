package tn.esprit.spring.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;


@Entity
@Table(name="pub")
@AllArgsConstructor
@Data



public class Publicite {
	@Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "content")
    private String content;
    
    
    
    
    @Lob
    @Column(nullable = true)
    private byte[] pic;
    
    @Transient
    private MultipartFile image;
    
    

    public Publicite() {
        
    }
    
    public Publicite(String name, String content, MultipartFile image ) {
        this.name = name;
        this.content = content;
        this.image=image;
    }
    
  
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}



	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	
	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}


	
	
	
	
	/*public long getid (){
		return id;
	}	
	public void setid (Long id){
		this.id= id;
	}*/	
	
	

}
