package edu.ufp.afmiguez.tk.ufp_api.services;

import edu.ufp.afmiguez.tk.ufp_api.models.responses.ResponseJSON;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import ufp.wsdl.Examelanguage;
import ufp.wsdl.ExamelanguageResponse;

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
        /**
         * TODO implement the assiduity
         */
//        try{
//            return ResponseJSON.createResponse(Utils.getValue(perfilResponse.getPerfillanguageResult(), PerfilResponseJSON.class));
//        }catch(IOException ioe){
//            return ResponseJSONString.createError("Check your credentials");
//        }
        return null;
    }
}
