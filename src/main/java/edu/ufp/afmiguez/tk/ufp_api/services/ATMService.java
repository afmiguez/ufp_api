package edu.ufp.afmiguez.tk.ufp_api.services;

import edu.ufp.afmiguez.tk.ufp_api.Utils;
import edu.ufp.afmiguez.tk.ufp_api.models.responses.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import ufp.wsdl.Atm;
import ufp.wsdl.AtmResponse;

import java.io.IOException;

public class ATMService extends GenericService {

    @Value("${wsdl.action.atm}")
    private String atmAction;

    public ResponseJSON getAtm(String token){
        Atm request=new Atm();
        request.setToken(token);
        AtmResponse response=(AtmResponse)getWebServiceTemplate()
                .marshalSendAndReceive(this.getUrl(),request,new SoapActionCallback(atmAction));

        this.logger.info(response.getAtmResult());
        if(response.getAtmResult().contains("Error")){
            return ResponseJSONObject.createError("Check your credentials");
        }
        try{
            return ResponseJSON.createResponse(Utils.getValue(response.getAtmResult(), ATMJson.class));
        }catch(IOException ioe){
            return ResponseJSONString.createResponse("No ATM reference available");
        }
    }


}
