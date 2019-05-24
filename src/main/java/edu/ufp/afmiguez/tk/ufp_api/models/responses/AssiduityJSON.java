package edu.ufp.afmiguez.tk.ufp_api.models.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class AssiduityJSON extends ResponseModel{
    @JsonProperty("assiduity")
    private List<AssiduityDetails> assiduity;
}

@Data
class AssiduityDetails {
    @JsonProperty("AnoLectivo")
    private String anoLectivo;

    @JsonProperty("Unidade")
    private String unidade;

    @JsonProperty("ECTS")
    private int ects;


    @JsonProperty("Tipo")
    private String tipo;


    @JsonProperty("Turma")
    private String turma;

    @JsonProperty("Assiduidade")
    private int assiduidade;


}