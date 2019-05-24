package edu.ufp.afmiguez.tk.ufp_api.models;

import lombok.Data;

@Data
public class Credential {
    private String username;
    private String password;

    public Credential() {
    }

    public Credential(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String toString(){
        return username+","+password;
    }

}
