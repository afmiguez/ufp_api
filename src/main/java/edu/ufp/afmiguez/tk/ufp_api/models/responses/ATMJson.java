package edu.ufp.afmiguez.tk.ufp_api.models.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ATMJson extends ResponseModel{
    //{ "status" : "Ok", "message" : { "Entidade" : "21497", "Total" : "202,53",
    // "Referencia" : "017 287 998", "Termo" : "2017-02-25", "Inicio" : "2017-02-14" } }
    @JsonProperty("Entidade")
    private String entidade;
    @JsonProperty("Total")
    private float total;
    @JsonProperty("Referencia")
    private String referencia;
    @JsonProperty("Termo")
    private String termo;
    @JsonProperty("Inicio")
    private String inicio;

}
