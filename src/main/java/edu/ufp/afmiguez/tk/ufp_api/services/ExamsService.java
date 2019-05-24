package edu.ufp.afmiguez.tk.ufp_api.services;

import edu.ufp.afmiguez.tk.ufp_api.Utils;
import edu.ufp.afmiguez.tk.ufp_api.models.responses.ExamesJSON;
import edu.ufp.afmiguez.tk.ufp_api.models.responses.ResponseJSON;
import edu.ufp.afmiguez.tk.ufp_api.models.responses.ResponseJSONString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import ufp.wsdl.Examelanguage;
import ufp.wsdl.ExamelanguageResponse;

import java.io.IOException;

public class ExamsService extends GenericService {

    @Value("${wsdl.action.examelanguage}")
    private String exameLanguageAction;

    public ResponseJSON getAssiduityLanguage(String token, String language){
        Examelanguage request=new Examelanguage();
        request.setToken(token);
        request.setLanguage(language);
        ExamelanguageResponse response=(ExamelanguageResponse)getWebServiceTemplate()
                .marshalSendAndReceive(this.getUrl(),request,new SoapActionCallback(exameLanguageAction));
        this.logger.info(response.getExamelanguageResult());

        try{
            return ResponseJSON.createResponse(Utils.getValue(response.getExamelanguageResult(), ExamesJSON.class));
        }catch(IOException ioe){
            ioe.printStackTrace();
            return ResponseJSONString.createError("Check your credentials");
        }
    }
}
