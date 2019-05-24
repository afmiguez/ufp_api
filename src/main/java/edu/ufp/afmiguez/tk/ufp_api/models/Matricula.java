package edu.ufp.afmiguez.tk.ufp_api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Matricula {

    @JsonProperty("Grau")
    private String grau;
    @JsonProperty("Curso")
    private String curso;


}
