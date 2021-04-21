package tn.esprit.spring.mailing;

import javax.validation.*;

import tn.esprit.spring.entity.Rayon;

import java.util.Set;

import javax.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Feedback {
	
	
	
    @javax.validation.constraints.NotNull
    private String name;

    @javax.validation.constraints.NotNull
    @javax.validation.constraints.Email
    private String email;

    @javax.validation.constraints.NotNull
    @javax.validation.constraints.Min(10)
    private String feedback;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
    
    
    
    
    
}
