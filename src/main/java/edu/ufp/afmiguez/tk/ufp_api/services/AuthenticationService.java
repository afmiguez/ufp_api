package edu.ufp.afmiguez.tk.ufp_api.services;

import edu.ufp.afmiguez.tk.ufp_api.models.Credential;
import edu.ufp.afmiguez.tk.ufp_api.models.responses.ResponseJSON;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import ufp.wsdl.*;

public class AuthenticationService extends GenericService {

    @Value("${wsdl.action.encrypt}")
    private String encryptAction;

    @Value("${wsdl.action.shakehands}")
    private String shakeHandAction;


    public ResponseJSON getToken(Credential credentials) {
        Encrypt request = new Encrypt();
        request.setPhrase(credentials.toString());

        EncryptResponse response = (EncryptResponse) getWebServiceTemplate()
                .marshalSendAndReceive(this.getUrl(), request
                        , new SoapActionCallback(encryptAction)
                );

        ShakeHands shakeHands = new ShakeHands();
        shakeHands.setInput(response.getEncryptResult());

        ShakeHandsResponse shakeHandsResponse = (ShakeHandsResponse) getWebServiceTemplate()
                .marshalSendAndReceive(this.getUrl(), shakeHands
                        , new SoapActionCallback(shakeHandAction)
                );
        if(shakeHandsResponse.getShakeHandsResult().isEmpty()){
            return ResponseJSON.createError("Check your credentials");
        }
        return ResponseJSON.createResponse(shakeHandsResponse.getShakeHandsResult());
    }

}
