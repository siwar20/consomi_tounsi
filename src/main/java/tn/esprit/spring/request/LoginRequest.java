package tn.esprit.spring.request;


public class LoginRequest {
        private  String userName ;
        private  String password ;
        //private String eNumber;

        public LoginRequest(String email, String password) {
            this.userName = email;
            this.password = password;
        }
    public LoginRequest(){}

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}