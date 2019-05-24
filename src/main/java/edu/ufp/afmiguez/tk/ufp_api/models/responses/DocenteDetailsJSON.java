package edu.ufp.afmiguez.tk.ufp_api.models.responses;

import edu.ufp.afmiguez.tk.ufp_api.models.Schedule;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class DocenteDetailsJSON extends ResponseModel {
    //{ "email" : "csoares@ufp.edu.pt", "schedule" : { "Atendimento (Porto)" : [ "Quarta das 13:00 às 14:00", "Quarta das 16:00 às 18:00", "Quinta das 18:00 às 19:00" ] }, "name" : "Prof. Doutor Christophe Soares", "last_update" : "2017-01-29" }
    private String email;
    private List<Schedule> schedule =new ArrayList<>();
    private String name;
    private LocalDate last_update;


}
