package edu.ufp.afmiguez.tk.ufp_api.services;

import edu.ufp.afmiguez.tk.ufp_api.models.responses.ResponseJSON;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import ufp.wsdl.Assiduitylanguage;
import ufp.wsdl.AssiduitylanguageResponse;

public class AssiduityService extends GenericService {
    @Value("${wsdl.action.assiduitylanguage}")
    private String assiduityLanguageAction;

    public ResponseJSON getAssiduityLanguage(String token, String language){
        Assiduitylanguage request=new Assiduitylanguage();
        request.setToken(token);
        request.setLanguage(language);
        AssiduitylanguageResponse response=(AssiduitylanguageResponse)getWebServiceTemplate()
                .marshalSendAndReceive(this.getUrl(),request,new SoapActionCallback(assiduityLanguageAction));
        this.logger.info(response.getAssiduitylanguageResult());
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
