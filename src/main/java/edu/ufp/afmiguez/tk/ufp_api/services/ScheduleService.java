package edu.ufp.afmiguez.tk.ufp_api.services;

import edu.ufp.afmiguez.tk.ufp_api.models.responses.ResponseJSON;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import ufp.wsdl.Schedulelanguage;
import ufp.wsdl.SchedulelanguageResponse;

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
        System.out.println(response.getSchedulelanguageResult());
        if(response.getSchedulelanguageResult().isEmpty()){
            return ResponseJSON.createError("Check your credentials");
        }
        return ResponseJSON.createResponse(response.getSchedulelanguageResult());
    }
}
