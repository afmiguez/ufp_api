package edu.ufp.afmiguez.tk.ufp_api.models.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.ufp.afmiguez.tk.ufp_api.models.Matricula;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class PerfilResponseJSON extends ResponseModel{

    @JsonProperty("Nome")
    private String nome;
    @JsonProperty("Numero")
    private String numero;
    @JsonProperty("Matricula")
    private List<Matricula> matricula=new ArrayList<>();
}
