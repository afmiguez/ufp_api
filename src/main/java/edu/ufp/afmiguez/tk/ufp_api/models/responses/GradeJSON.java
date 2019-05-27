package edu.ufp.afmiguez.tk.ufp_api.models.responses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
public class GradeJSON extends ResponseModel {
    @JsonProperty("grade")
    private Grade grade;

}

@Data
class Grade {
    @JsonProperty("definitivo")
    private List<GradeDetails> definitivo;

    @JsonProperty("provisorio")
    private GradeProvisory provisorio;
}

@Data
class GradeDetails {
    @JsonProperty("Grau")
    private String grau;
    @JsonProperty("Unidade")
    private String unidade;
    @JsonProperty("Curso")
    private String curso;
    @JsonProperty("ECTS")
    private int ECTS;
    @JsonProperty("Nota")
    private int nota;
    @JsonProperty("Registo")
    private String registo;
}

@Data
class GradeProvisory {

    @JsonProperty("parciais")
    private List<GradePartialDetails> parciais;

    //    @JsonProperty("finais")
    @JsonIgnore
    private List<GradeDetails> finais;
}

@Data
class GradePartialDetails {
    @JsonProperty("AnoLectivo")
    private String anoLectivo;
    @JsonProperty("Modelo")
    private String modelo;
    @JsonProperty("Unidade")
    private String unidade;
    @JsonProperty("Elemento")
    private String elemento;
    @JsonProperty("Nota")
    private String nota;
    @JsonProperty("Responsavel")
    private String responsavel;
    @JsonProperty("Registo")
    private String registo;
    @JsonProperty("ECTS")
    private int ects;
}
