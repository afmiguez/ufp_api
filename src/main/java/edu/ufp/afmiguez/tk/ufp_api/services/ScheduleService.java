package edu.ufp.afmiguez.tk.ufp_api.services;

import edu.ufp.afmiguez.tk.ufp_api.Utils;
import edu.ufp.afmiguez.tk.ufp_api.models.responses.GradeJSON;
import edu.ufp.afmiguez.tk.ufp_api.models.responses.ResponseJSON;
import edu.ufp.afmiguez.tk.ufp_api.models.responses.ResponseJSONObject;
import edu.ufp.afmiguez.tk.ufp_api.models.responses.ScheduleJSON;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import ufp.wsdl.Schedulelanguage;
import ufp.wsdl.SchedulelanguageResponse;

import java.io.IOException;

public class ScheduleService extends GenericService {

    @Value("${wsdl.action.schedulelanguage}")
    private String scheduleLanguageAction;

    public ResponseJSON getSchedules(String token,String language) {
        Schedulelanguage request = new Schedulelanguage();
        request.setToken(token);
        request.setLanguage(language);
        SchedulelanguageResponse response = (SchedulelanguageResponse) getWebServiceTemplate()
                .marshalSendAndReceive(this.getUrl(), request
                        , new SoapActionCallback(scheduleLanguageAction)
                );
        try{
            return ResponseJSON.createResponse(Utils.getValue(response.getSchedulelanguageResult(), ScheduleJSON.class));
        }catch(IOException ioe){
            return ResponseJSONObject.createError("No grades available");
        }
    }
}
