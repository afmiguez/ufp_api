package edu.ufp.afmiguez.tk.ufp_api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public abstract class GenericService extends WebServiceGatewaySupport {

    protected Logger logger= LoggerFactory.getLogger(this.getClass());

    @Value("${wsdl.url}")
    private String url = "https://portal.ufp.pt/hi5.asmx?WSDL";

    public String getUrl() {
        return url;
    }
}
