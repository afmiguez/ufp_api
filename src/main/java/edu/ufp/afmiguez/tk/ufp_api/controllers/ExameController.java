package edu.ufp.afmiguez.tk.ufp_api.controllers;

import edu.ufp.afmiguez.tk.ufp_api.models.responses.ResponseJSON;
import edu.ufp.afmiguez.tk.ufp_api.services.ExamsService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExameController {

    private ExamsService examsService;

    public ExameController(ExamsService examsService) {
        this.examsService = examsService;
    }

    @GetMapping(value="/exame",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseJSON> getAssiduity(@RequestParam String token, @RequestParam String language){
        ResponseJSON responseJSON=examsService.getAssiduityLanguage(token,language);
        if(responseJSON==null||responseJSON.getStatus().equals("Error")){
            return ResponseEntity.badRequest().body(responseJSON);
        }
        return ResponseEntity.ok(responseJSON);
    }
}
