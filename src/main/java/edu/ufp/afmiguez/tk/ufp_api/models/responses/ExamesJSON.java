package edu.ufp.afmiguez.tk.ufp_api.models.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ExamesJSON extends ResponseModel{
    @JsonProperty("Exames")
    private List<ExameDetails> exames;


}

@Data
class ExameDetails {
    @JsonProperty("Disciplina")
    private String disciplina;

    @JsonProperty("Curso")
    private String curso;

    @JsonProperty("Tipologia")
    private String tipologia;

    @JsonProperty("Data")
    private String data;

    @JsonProperty("AnoLectivo")
    private String anoLectivo;

    @JsonProperty("Sala")
    private String sala;

    @JsonProperty("Responsavel")
    private String responsavel;

    @JsonProperty("ECTS")
    private String ects;
}
