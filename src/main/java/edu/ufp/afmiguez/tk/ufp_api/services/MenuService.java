package edu.ufp.afmiguez.tk.ufp_api.services;

import edu.ufp.afmiguez.tk.ufp_api.models.responses.ResponseJSON;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import ufp.wsdl.Menu;
import ufp.wsdl.MenuResponse;

public class MenuService extends GenericService{
    @Value("${wsdl.action.menu}")
    private String menuAction;

    public ResponseJSON getMenu() {
        Menu docentes = new Menu();
        MenuResponse response = (MenuResponse) getWebServiceTemplate()
                .marshalSendAndReceive(this.getUrl(), docentes
                        , new SoapActionCallback(menuAction)
                );
        System.out.println(response.getMenuResult());
        /**
         * TODO
         */
        return null;

    }
}
