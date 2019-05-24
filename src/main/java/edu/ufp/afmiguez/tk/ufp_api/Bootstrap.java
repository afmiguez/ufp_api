package edu.ufp.afmiguez.tk.ufp_api;

import edu.ufp.afmiguez.tk.ufp_api.models.Credential;
import edu.ufp.afmiguez.tk.ufp_api.services.AuthenticationService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthenticationService authenticationService;

    public Bootstrap(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    }
}
