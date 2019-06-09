package edu.ufp.afmiguez.tk.ufp_api.models.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/*
{"atm": [{"Entidade": "21097", "Referencia": "011 938 594",
"Total": "90,00", "Inicio": "2019-05-27", "Termo": "2019-06-10"}]}
 */

@Data
public class ATMJson extends ResponseModel{
    //{ "status" : "Ok", "message" : { "Entidade" : "21497", "Total" : "202,53",
    // "Referencia" : "017 287 998", "Termo" : "2017-02-25", "Inicio" : "2017-02-14" } }

    private List<ATMDetails> atm;

}

@Data
class ATMDetails{
    @JsonProperty("Entidade")
    private String entidade;
    @JsonProperty("Total")
    private String total;
    @JsonProperty("Referencia")
    private String referencia;
    @JsonProperty("Termo")
    private String termo;
    @JsonProperty("Inicio")
    private String inicio;
}

