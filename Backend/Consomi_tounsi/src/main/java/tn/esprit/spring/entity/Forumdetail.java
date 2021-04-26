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
@Table(name="forumdetail")
@AllArgsConstructor
@Data

@ToString

public class Forumdetail {
	
	@Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "content")
    private String content;
    @Column(name="date")
    private Date date;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Forum forum;
    
    @Lob
    @Column(nullable = true)
    private byte[] pic;
    
    @Transient
    private MultipartFile image;
    
    @Transient
    private long forumId;

    public Forumdetail() {
        
    }
    
    public Forumdetail(String name, String content, long forumId, MultipartFile image ) {
        this.name = name;
        this.content = content;
        this.forumId=forumId;
        this.image=image;
    }
    
    public Forumdetail(String name, String content) {
        this.name = name;
        this.content = content;
        
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public Forum getForum() {
		return forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
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

	public long getForumId() {
		return forumId;
	}

	public void setForumId(long forumId) {
		this.forumId = forumId;
	}
	
	
	
	
	/*public long getid (){
		return id;
	}	
	public void setid (Long id){
		this.id= id;
	}*/	
	
	

}
