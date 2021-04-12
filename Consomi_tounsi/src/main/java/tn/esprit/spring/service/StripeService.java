package tn.esprit.spring.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Card;
import com.stripe.model.Charge;
import com.stripe.model.Token;

import tn.esprit.spring.request.ChargeRequest;

@Service
public class StripeService {

    @Value("${stripe.key.secret}")
    private String secretKey;
    
    @PostConstruct
    public void init() {
        Stripe.apiKey = secretKey;
    }
    
    public Token createCard() throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
    {
    	Map<String, Object> map = new HashMap<>();
    	map.put("number", "4242424242424242");
    	map.put("exp_month", 02);
    	map.put("exp_year", 22);
    	map.put("cvc", 333);
    	Map<String, Object> cardMap = new HashMap<>();
    	cardMap.put("card", map);
    	return Token.create(cardMap);
    }
    
    public Charge charge(ChargeRequest chargeRequest) 
    	      throws AuthenticationException, InvalidRequestException,
    	        APIConnectionException, CardException, APIException {
    	        Map<String, Object> chargeParams = new HashMap<>();
    	        chargeParams.put("amount", (int)chargeRequest.getAmount());
    	        chargeParams.put("currency", chargeRequest.getCurrency());
    	        chargeParams.put("description", chargeRequest.getDescription());
    	        chargeParams.put("source", chargeRequest.getStripeToken());
    	        return Charge.create(chargeParams);
    	    }

}
