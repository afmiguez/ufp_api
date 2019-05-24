package edu.ufp.afmiguez.tk.ufp_api.controllers;

import edu.ufp.afmiguez.tk.ufp_api.models.responses.ResponseJSON;
import edu.ufp.afmiguez.tk.ufp_api.services.ScheduleService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ScheduleController {

    private ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping(value="/schedule",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseJSON> getPerfil(@RequestParam String token, @RequestParam String language){
        ResponseJSON responseJSON=scheduleService.getSchedules(token,language);
        if(responseJSON.getStatus().equals("Error")){
            return ResponseEntity.badRequest().body(responseJSON);
        }
        return ResponseEntity.ok(responseJSON);
    }
}
