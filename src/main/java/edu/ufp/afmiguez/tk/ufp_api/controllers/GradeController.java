package edu.ufp.afmiguez.tk.ufp_api.controllers;

import edu.ufp.afmiguez.tk.ufp_api.models.responses.GradeJSON;
import edu.ufp.afmiguez.tk.ufp_api.models.responses.ResponseJSON;
import edu.ufp.afmiguez.tk.ufp_api.services.GradesService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GradeController {

    private GradesService gradesService;

    public GradeController(GradesService gradesService) {
        this.gradesService = gradesService;
    }

    @GetMapping(value="/grades/{param}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseJSON> getGrades(@RequestParam String token, @RequestParam String language, @PathVariable String param){
        ResponseJSON responseJSON=gradesService.getGradeLanguage(token,language,param);
        if(responseJSON.getStatus().equals("Error")){
            return ResponseEntity.badRequest().body(responseJSON);
        }

        return ResponseEntity.ok(responseJSON);
    }
}
