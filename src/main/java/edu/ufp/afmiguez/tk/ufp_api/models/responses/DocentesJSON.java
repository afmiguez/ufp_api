package edu.ufp.afmiguez.tk.ufp_api.models.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class DocentesJSON extends ResponseModel{

    @JsonProperty("Docentes")
    private List<DocenteJSON> docentes=new ArrayList<>();
}
