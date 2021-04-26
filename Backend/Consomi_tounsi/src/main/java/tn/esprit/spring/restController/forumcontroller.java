package tn.esprit.spring.restController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mysql.cj.protocol.Message;

import tn.esprit.spring.entity.Forum;
import tn.esprit.spring.entity.Forumdetail;
import tn.esprit.spring.entity.Mots;
import tn.esprit.spring.repository.ForumsRepository;
import tn.esprit.spring.repository.MotsRepository;
import tn.esprit.spring.repository.forumdetailleRepository;
import tn.esprit.spring.service.impl.Forumservice;



@RestController
@RequestMapping("/forum")

public class forumcontroller {
	@Autowired
	Forumservice forumservice;
	@Autowired
	forumdetailleRepository forumdrepo;
	@Autowired
	ForumsRepository forumrepos;
	
   @Autowired
   MotsRepository motrepo;

	//posterforumdetail//
	/*public void addSubject(Subject Su) { //boolean
    boolean prohibited = false;
    List<String> prohibitedDict = Arrays.asList("barcha", "klem", "khayeb");
    List<String> List = new ArrayList<String>(Arrays.asList(Su.getDescriptionSubject().split("\\s+")));
    for (String word : List ) {
        if (prohibitedDict.contains(word)){ prohibited = true ;}
    }
    if (prohibited == false )
    { Su.setLikesSubject(0);
      Su.setFeaturedSubject(false);
        sr.save(Su);
    }
}*/
	
	
	
	@PostMapping("/poster")
	public ResponseEntity<?> poster(@ModelAttribute Forumdetail forumdet) throws IOException {
		Forum forum = forumservice.getForumById(forumdet.getForumId());
		
		forumdet.setDate(new Date());
		forumdet.setForum(forum);
		if (forumdet.getImage() != null) {
			forumdet.setPic(forumdet.getImage().getBytes());
		}
		boolean prohibited = false;
		long i=66;
		Mots m=forumservice.getmotbyid(i);
	    List<String> prohibitedDict = new ArrayList<String>(Arrays.asList(m.getSubject().split("\\s+")));
	    List<String> List = new ArrayList<String>(Arrays.asList(forumdet.getContent().split("\\s+")));
	    for (String word : List ) {
	        if (prohibitedDict.contains(word)){ 
	        	prohibited = true ;
	        
	        return new ResponseEntity<>(new Responsemodel("restricted words"), HttpStatus.FORBIDDEN);    
	        }
	    }
	    if (prohibited == false )
	     
				
		forumservice.publier(forumdet);
		return new ResponseEntity<>(new Responsemodel("added"), HttpStatus.CREATED);
	   
	    }
	/**
	 * @GetMapping("/afficher") public List<Forumdetail> retrievecomments() { return
	 * Forumservice.afficher(); }
	 *///
	//afficherforumdetail//
	@GetMapping("/afficherforumdetail")
	public List<Forumdetail> afficherforumdetail() {
		return forumservice.afficher();

	}
//deleteforumbyid//
	@DeleteMapping("delete/{id}")
	public HttpStatus deleteForum(@PathVariable("id") Long id) throws RelationNotFoundException {
		forumservice.deleteForumdetailById(id);
		return HttpStatus.FORBIDDEN;
	}
//post forum//
	
	
	
	@PostMapping("/posterforum")
	public ResponseEntity<?> posterforum(@RequestBody Forum forum) {
		forumservice.publiertt(forum);
		return new ResponseEntity<>(new Responsemodel("added"), HttpStatus.CREATED);
	}
//ajouter mots interdits//
	@PostMapping("/ajoutermots")
	public ResponseEntity<?> ajoutermots(@RequestBody Mots m) {
		motrepo.save(m);
		return new ResponseEntity<>(new Responsemodel("added"), HttpStatus.CREATED);
	}
	
	
	//likebutton forum/	
	@PutMapping("/addlike/{id}")
    public void addLike(@PathVariable("id") long id){
		forumservice.addLike(id);
		}
	
	
	
	
	/*@PutMapping("/addlike")
	public void addLike(Forum f){
		int nb = f.getLikesForum() + 1;
		f.setLikes(nb);
		forumservice.publiertt(f);
		
		}*/
	//delete forum detail//
	@DeleteMapping("/deleteallforum/{id}")
	public HttpStatus deleteForumall(@PathVariable("id") Long id) throws RelationNotFoundException {
		forumservice.deleteForumdeById(id);
		return HttpStatus.FORBIDDEN;
	}
	//update forum//
	@PutMapping("/updateforum/{id}")
	public ResponseEntity<?> updateforumdforum(@PathVariable("id") long id,
			@RequestBody Forum forumdet) throws IOException{
		Optional<Forum> newform = forumrepos.findById(id);

		if (newform.isPresent()) {
			Forum Newwform = newform.get();
			
			Newwform.setSubject(forumdet.getSubject());
			

			return new ResponseEntity<>(forumrepos.save(Newwform), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	//afficherforum//
	@GetMapping("/afficherforum")
	public List<Forum> afficherforum() {
		return forumservice.afficherall();

	}
	
	//updateforumdetail by id//
	@PutMapping("/update/{id}")
	public ResponseEntity<Forumdetail> updateforumdetail(@PathVariable("id") long id,
			@ModelAttribute Forumdetail forumdet) throws IOException {
		Optional<Forumdetail> newform = forumdrepo.findById(id);

		if (newform.isPresent()) {
			Forumdetail Newwform = newform.get();
			Newwform.setName(forumdet.getName());
			Newwform.setContent(forumdet.getContent());
			if (forumdet.getImage() != null) {
				Newwform.setPic(forumdet.getImage().getBytes());
			}

			return new ResponseEntity<>(forumdrepo.save(Newwform), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	
	
	} 
	
	//afficher les plus like //
	
	@GetMapping("/pluslike")
	public List<Forum> afficherplus() {
		return forumservice.afficherplus();

	}
	
	
	
	
    }
	
	
	
	
		
	
	
	


