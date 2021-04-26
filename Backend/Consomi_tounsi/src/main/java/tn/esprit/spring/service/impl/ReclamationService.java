package tn.esprit.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.reclamation;
import tn.esprit.spring.repository.ReclamationRepository;

import java.util.List;
import java.util.Optional;

@Service
    public class ReclamationService {
    @Autowired
    ReclamationRepository r;

    public List<reclamation> retrieveAllReclamation() {
        return (List<reclamation>) r.findAll();
    }


    public reclamation addReclamation(reclamation rr) {
        return r.save(rr);
    }


    public void deleteReclamation(int id) {
        Optional<reclamation> optionalReclamation = r.findById(id);
        if (!optionalReclamation.isPresent()) {
            throw new IllegalStateException("Reclamation Not Found");
        }
        r.deleteById(id);

    }




    public reclamation updateReclamation(reclamation rr) {
        return r.save(rr);
    }


    public Optional<reclamation> FindReclamation(int id) {
        return r.findById(id);
    }


}
