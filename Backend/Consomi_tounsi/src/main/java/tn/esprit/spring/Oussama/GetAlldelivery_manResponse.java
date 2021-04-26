package tn.esprit.spring.Oussama;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.spring.entity.delivery_man;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAlldelivery_manResponse {
    private List<delivery_man> list;

}
