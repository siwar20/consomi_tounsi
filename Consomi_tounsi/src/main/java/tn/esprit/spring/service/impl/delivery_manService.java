package tn.esprit.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Delivery;
import tn.esprit.spring.entity.delivery_man;
import tn.esprit.spring.repository.DeliveryRepository;
import tn.esprit.spring.repository.delivery_manRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Transactional
@Service
public class delivery_manService {
    @Autowired

    delivery_manRepository D;
    @Autowired
    DeliveryRepository deliveryRepository;

    public List<delivery_man> retrieveAllDelivery_man() {
        return (List<delivery_man>) D.findAll();
    }


    public delivery_man  addDelivery_man(delivery_man DD) {
        return D.save(DD);}



    public void deleteDelivery_man(int id) {
        Optional<delivery_man> optionaldelivery_man=D.findById(id);
        if (!optionaldelivery_man.isPresent()) {
            throw new IllegalStateException("delivery_man Not Found");
        }
        D.deleteById(id);

    }



    public delivery_man updatedelivery_man(delivery_man DD) {
        return D.save(DD);
    }


    public Optional<delivery_man> Finddelivery_man(int id) {
        return   D.findById(id);
    }


    public Optional<delivery_man> FindDelivery_man(String id) {
        return  D.findById(Integer.parseInt(id));
    }


    //calculer les salaires totales des Livreurs
    public double SommeSaliaredelivery_man() {
        return D.salairedeliveryman(); }




    //calculer salaire avec Prime
    public void salaireAvecPrime() {
        for (delivery_man d : (List<delivery_man>) D.findAll()){
            double nb =0;
            nb = d.getSalaire() + d.getBonus();
            D.salaireprimé(nb , d.getId());}
    }
    // update bonus de deliverman
    public double updateprimeDeliverer(int id) {
        double nb = 0;
        return D.primeupdate(nb,id);
    }
    //calculat prime
    public  double calculprime(delivery_man d){
        double x=0;
        if (d.getDistance()>100 && d.getDistance()<200){
            x=x+50;

        }
        else if (d.getDistance()>500 && d.getDistance()<200){
            x=x+150;
        }
        else{
            x=x+200;
        }
        return x;
    }

    /*public ResponseEntity<?> addDeliveryMantoDelivery (int id , List<Delivery> deliveryList){
        for ( Delivery delivery : deliveryList ){
            Optional<Delivery> optionalDelivery = deliveryRepository.findById(delivery.getId());
            if (!optionalDelivery.isPresent()){
                return  new ResponseEntity<>( new MessageResponseModel( " The Delivery with Id  "+ delivery.getId()
                        +"Does not exist "), HttpStatus.BAD_REQUEST );

            }

            Optional<delivery_man> optionalDelivery_man = D.findById(id);

            if ( !optionalDelivery_man.isPresent()){
                return  new ResponseEntity<>( new MessageResponseModel("¨Deliveryman id not Found "),HttpStatus.BAD_REQUEST) ;

            }

            delivery_man delivery_man =  optionalDelivery_man.get();
            List<Delivery> deliveryList1=new ArrayList<>();
            deliveryList1.add(delivery);
            delivery_man.setDelivery(deliveryList1);
            this.D.save(delivery_man);
        }
        return  new ResponseEntity<>( HttpStatus.OK);}

     */
    public void addDeliveryMantoDelivery (int id , Delivery deliveryList){
        List<Delivery> deliveryList1=new ArrayList<>();




            Optional<delivery_man> optionalDelivery_man = D.findById(id);


            delivery_man delivery_man =  optionalDelivery_man.get();
            deliveryList1.add(deliveryList);
            delivery_man.setDelivery(deliveryList1);
            D.save(delivery_man);

        }






    }

