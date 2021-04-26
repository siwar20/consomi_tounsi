package tn.esprit.spring.service.impl;

import java.util.List;
import java.util.Optional;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Forum;
import tn.esprit.spring.entity.Forumdetail;
import tn.esprit.spring.entity.Mots;
import tn.esprit.spring.repository.ForumsRepository;
import tn.esprit.spring.repository.MotsRepository;
import tn.esprit.spring.repository.forumdetailleRepository;



@Service

public class Forumservice {

	@Autowired

	ForumsRepository forumrepo;

	@Autowired
	forumdetailleRepository forumDetailRepo;
	
	@Autowired
	MotsRepository motrep;

	public Forumdetail publier(Forumdetail forumdet) {
		/*
		 * try { forumrepo.save(new Forumdetail(forumdet.getcontent(),
		 * forumdet.getName(), null); return new ResponseEntity<>(forumdet,
		 * HttpStatus.CREATED); } catch (Exception e) { return new
		 * ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); } }
		 */

		return forumDetailRepo.save(forumdet);
	}

	public List<Forumdetail> afficher() {
		return forumDetailRepo.findAll();
	}

	public void deleteForumdetailById(Long id) throws RelationNotFoundException {
		Optional<Forumdetail> forumdeta = forumDetailRepo.findById(id);

		if (forumdeta.isPresent()) {
			forumDetailRepo.deleteById(id);
		} else {
			throw new RelationNotFoundException("No F record exist for given id");
		}
	}

	public Forum publiertt(Forum forum) {
		
		return forumrepo.save(forum);
	}

	public Forum getForumById(long id) {
		return forumrepo.getOne(id);
	}
	
	public void addLike(long id) {
		Forum a = forumrepo.findById(id).orElse(new Forum());
        int nb = a.getLikes()+ 1;
        a.setLikes(nb);
        forumrepo.save(a);
       
		
	}

	public void deleteForumdeById(Long id)  throws RelationNotFoundException {
		Optional<Forum> forumdeta = forumrepo.findById(id);

		if (forumdeta.isPresent()) {
			forumrepo.deleteById(id);
		} else {
			throw new RelationNotFoundException("No F record exist for given id");
		}
		
	
	}
	/*
	 * public Forumdetail Updateforumdetail(Forumdetail forumdet) { long idd =
	 * forumdet.getId(); Optional<Forumdetail> forumdeta = forumrepo.findById(idd);
	 * 
	 * if(forumdeta.isPresent()) { Forumdetail newcommenatire = forumdeta.get();
	 * newcommenatire.setName(forumdet.getName());
	 * newcommenatire.setDate(forumdet.getDate());
	 * newcommenatire.setContent(forumdet.getContent());
	 * 
	 * newcommenatire = forumrepo.save(newcommenatire);
	 * 
	 * return newcommenatire; } else { forumdet = forumrepo.save(forumdet);
	 * 
	 * return forumdet; } }
	 */

	public List<Forum> afficherall() {
		return forumrepo.findAll();
	}

	public Mots getmotbyid(long i) {
		
		return motrep.getOne(i);
	}

	public List<Forum> afficherplus() {
		// TODO Auto-generated method stub
		return forumrepo.findbylikes();
	}
}
	
	

