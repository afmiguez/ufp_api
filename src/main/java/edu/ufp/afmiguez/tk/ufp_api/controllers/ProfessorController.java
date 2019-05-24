package edu.ufp.afmiguez.tk.ufp_api.controllers;

import edu.ufp.afmiguez.tk.ufp_api.models.responses.ResponseJSON;
import edu.ufp.afmiguez.tk.ufp_api.services.ProfessorScheduleService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProfessorController {
    private ProfessorScheduleService professorScheduleService;

    public ProfessorController(ProfessorScheduleService professorScheduleService) {
        this.professorScheduleService = professorScheduleService;
    }

    @GetMapping(value="/teachers/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseJSON> getProfessores(){
        return ResponseEntity.ok(professorScheduleService.getDocentes());
    }

    @GetMapping(value="/teachers/{initial}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseJSON> getProfessor(@PathVariable String initial){
        return ResponseEntity.ok(professorScheduleService.getDocenteInformation(initial));
    }
}
