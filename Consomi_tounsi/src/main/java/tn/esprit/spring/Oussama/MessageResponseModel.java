package tn.esprit.spring.Oussama;

public class MessageResponseModel {
    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageResponseModel(String message) {
        this.message = message;
    }
}
