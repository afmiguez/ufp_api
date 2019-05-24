package edu.ufp.afmiguez.tk.ufp_api.controllers;

import edu.ufp.afmiguez.tk.ufp_api.models.responses.ResponseJSON;
import edu.ufp.afmiguez.tk.ufp_api.services.StudentPerfilService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PerfilController {
    private StudentPerfilService studentPerfilService;

    public PerfilController(StudentPerfilService studentPerfilService) {
        this.studentPerfilService = studentPerfilService;
    }

    @GetMapping(value="/profile",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseJSON> getPerfil(@RequestParam String token,@RequestParam String language){
        ResponseJSON responseJSON=studentPerfilService.getPerfilLanguage(token,language);
        if(responseJSON.getStatus().equals("Error")){
            return ResponseEntity.badRequest().body(responseJSON);
        }
        return ResponseEntity.ok(responseJSON);
    }
}
