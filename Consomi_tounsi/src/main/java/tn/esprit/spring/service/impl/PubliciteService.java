package tn.esprit.spring.service.impl;

import java.util.List;
import java.util.Optional;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Publicite;
import tn.esprit.spring.repository.PubliciteRepository;



@Service

public class PubliciteService {
	
@Autowired
	
	PubliciteRepository pubrepo;



	public  Publicite publier(Publicite publi) {
		// TODO Auto-generated method stub
		return pubrepo.save(publi);
	}



	public List<Publicite> afficherpub() {
		// TODO Auto-generated method stub
		return pubrepo.findAll();
	}



	public void deletepubById(Long id) throws RelationNotFoundException {
		Optional <Publicite> pbb = pubrepo.findById(id);

		if (pbb.isPresent()) {
			pubrepo.deleteById(id);
		} else {
			throw new RelationNotFoundException("No F record exist for given id");
		}
	}
}
