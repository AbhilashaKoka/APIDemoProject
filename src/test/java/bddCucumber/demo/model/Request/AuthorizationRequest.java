package bddCucumber.demo.model.Request;

import lombok.Data;

@Data
public class AuthorizationRequest {
    private String userName;
    private String password;


    public AuthorizationRequest(String userName, String password) {
        this.userName=userName;
        this.password=password;
    }
}