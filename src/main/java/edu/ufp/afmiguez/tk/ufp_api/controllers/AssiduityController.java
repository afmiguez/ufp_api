package edu.ufp.afmiguez.tk.ufp_api.controllers;

import edu.ufp.afmiguez.tk.ufp_api.models.responses.ResponseJSON;
import edu.ufp.afmiguez.tk.ufp_api.services.AssiduityService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AssiduityController {

    private AssiduityService assiduityService;

    public AssiduityController(AssiduityService assiduityService) {
        this.assiduityService = assiduityService;
    }

    @GetMapping(value="/assiduity",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseJSON> getAssiduity(@RequestParam String token, @RequestParam String language){
        ResponseJSON responseJSON=assiduityService.getAssiduityLanguage(token,language);
        if(responseJSON==null||responseJSON.getStatus().equals("Error")){
            return ResponseEntity.badRequest().body(responseJSON);
        }
        return ResponseEntity.ok(responseJSON);
    }
}
