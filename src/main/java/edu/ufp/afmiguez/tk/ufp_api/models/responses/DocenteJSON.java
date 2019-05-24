package edu.ufp.afmiguez.tk.ufp_api.models.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DocenteJSON extends ResponseModel{
    @JsonProperty("Docente")
    private String docente;
    @JsonProperty("Sigla")
    private String sigla;
}
