package edu.ufp.afmiguez.tk.ufp_api.services;

import edu.ufp.afmiguez.tk.ufp_api.Utils;
import edu.ufp.afmiguez.tk.ufp_api.models.responses.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import ufp.wsdl.Perfillanguage;
import ufp.wsdl.PerfillanguageResponse;

import java.io.IOException;

public class StudentPerfilService extends GenericService {

    @Value("${wsdl.action.perfil}")
    private String perfilAction;

    @Value("${wsdl.action.perfillanguage}")
    private String perfilLanguageAction;


    public ResponseJSON getPerfilLanguage(String token, String language){
        Perfillanguage perfil=new Perfillanguage();
        perfil.setToken(token);
        perfil.setLanguage(language);
        PerfillanguageResponse response=(PerfillanguageResponse)getWebServiceTemplate()
                .marshalSendAndReceive(this.getUrl(),perfil,new SoapActionCallback(perfilLanguageAction));
        if(response.getPerfillanguageResult().contains("Error")){
            return ResponseJSONString.createError("Check your credentials");
        }
        try{
            return ResponseJSON.createResponse(Utils.getValue(response.getPerfillanguageResult(), PerfilResponseJSON.class));
        }catch(IOException ioe){
            return ResponseJSONString.createError("Error at getting student profile");
        }
    }
}
