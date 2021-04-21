package tn.esprit.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Delivery;
import tn.esprit.spring.entity.orders;
import tn.esprit.spring.repository.DeliveryRepository;

import java.util.*;

@Service
public class DeliveryService {
    @Autowired

    DeliveryRepository D;

    public List<Delivery> retrieveAllDelivery() {
        return (List<Delivery>) D.findAll();
    }


    public Delivery  addDelivery(Delivery DD) {
        return D.save(DD);
    }


    public void deleteDelivery(int id) {
        Optional<Delivery> optionalDelivery=D.findById(id);
        if (!optionalDelivery.isPresent()) {
            throw new IllegalStateException("Delivery Not Found");
        }
        D.deleteById(id);

    }


    public void deleteDelivery(String id) {
        D.deleteById(Integer.parseInt(id));
    }


    public Delivery updateDelivery(Delivery DD) {
        return D.save(DD);
    }


    public Optional<Delivery> FindDelivery(int id) {
        return   D.findById(id);
    }


    public Optional<Delivery> FindDelivery(String id) {
        return  D.findById(Integer.parseInt(id));
    }
//Calcul frais
    public double calculFrais (Delivery D){
        List<orders> ordersList=D.getOrders();
        double frais_moy_tran=D.getPrice();
        String moy_transport=D.getMoyenDeTransport();
        if(moy_transport.equals("car"))
            frais_moy_tran+=2;
        else
        {
                frais_moy_tran+=6;
        }
        float poids=0;
        //List<orders> l=new ArrayList<>(ordersList);//
        for(int i=0;i<ordersList.size();i++)
        {
            poids+=ordersList.get(i).getWeight();
        }
        if(poids>5 && poids <10)
            frais_moy_tran+=5;
        else
            frais_moy_tran+=10;
        return frais_moy_tran;
    }

}

