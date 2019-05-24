package edu.ufp.afmiguez.tk.ufp_api.models.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class ScheduleJSON extends ResponseModel {

    private List<ScheduleDetails> schedule;
}

class ScheduleDetails{

    @JsonProperty("Data")
    private String data;

    @JsonProperty("Inicio")
    private String inicio;

    @JsonProperty("Termo")
    private String termo;

    @JsonProperty("Sala")
    private String sala;

    @JsonProperty("Categoria")
    private String categoria;


    @JsonProperty("AnoLectivo")
    private String anoLectivo;

    @JsonProperty("Curso")
    private String curso;

    @JsonProperty("Grau")
    private String grau;

    @JsonProperty("Unidade")
    private String unidade;

    @JsonProperty("Tipo")
    private String tipo;

    @JsonProperty("ECTS")
    private int ects;

}
