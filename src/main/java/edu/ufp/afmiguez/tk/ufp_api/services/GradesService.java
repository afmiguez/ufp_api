package edu.ufp.afmiguez.tk.ufp_api.services;

import edu.ufp.afmiguez.tk.ufp_api.Utils;
import edu.ufp.afmiguez.tk.ufp_api.models.responses.GradeJSON;
import edu.ufp.afmiguez.tk.ufp_api.models.responses.ResponseJSON;
import edu.ufp.afmiguez.tk.ufp_api.models.responses.ResponseJSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import ufp.wsdl.Gradelanguage;
import ufp.wsdl.GradelanguageResponse;

import java.io.IOException;

public class GradesService extends GenericService {
    @Value("${wsdl.action.gradelanguage}")
    private String gradeLanguageAction;

    public ResponseJSON getGradeLanguage(String token, String language){
        Gradelanguage request=new Gradelanguage();
        request.setToken(token);
        request.setLanguage(language);
        GradelanguageResponse response=(GradelanguageResponse)getWebServiceTemplate()
                .marshalSendAndReceive(this.getUrl(),request,new SoapActionCallback(gradeLanguageAction));
        if(response.getGradelanguageResult().contains("Error")){
            return ResponseJSONObject.createError("Check your credentials");
        }
        this.logger.info(response.getGradelanguageResult());
        /**
         * TODO implement the assiduity
         */
        try{
            return ResponseJSON.createResponse(Utils.getValue(response.getGradelanguageResult(), GradeJSON.class));
        }catch(IOException ioe){
            return ResponseJSONObject.createError("No grades available");
        }
    }

}
