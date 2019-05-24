package edu.ufp.afmiguez.tk.ufp_api.controllers;

import edu.ufp.afmiguez.tk.ufp_api.models.responses.ResponseJSON;
import edu.ufp.afmiguez.tk.ufp_api.services.ATMService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ATMController {
    private ATMService atmService;

    public ATMController(ATMService atmService) {
        this.atmService = atmService;
    }

    @GetMapping(value="/atm",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseJSON> getAssiduity(@RequestParam String token){
        ResponseJSON responseJSON=atmService.getAtm(token);
        if(responseJSON==null||responseJSON.getStatus().equals("Error")){
            return ResponseEntity.badRequest().body(responseJSON);
        }
        return ResponseEntity.ok(responseJSON);
    }
}
