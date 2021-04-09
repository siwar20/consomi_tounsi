package tn.esprit.spring.Oussama;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.spring.entity.paiments;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_Orders")
public class orders implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Orders_id;
    @Temporal(TemporalType.DATE)
    private Date order_date;
    public float weight;

    @OneToOne
    private paiments Paiments;

    @ManyToOne()
    Delivery delivery;

    @ManyToOne
    tn.esprit.spring.entity.customer customer;

    @ManyToOne
    tn.esprit.spring.entity.Product Product;


}
