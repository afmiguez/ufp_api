package edu.ufp.afmiguez.tk.ufp_api;

import edu.ufp.afmiguez.tk.ufp_api.services.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;


@Configuration
public class WSDLConfiguration {

    @Value("${wsdl.url}")
    private String url;

    @Value("${wsdl.path}")
    private String path;


    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath(path);
        return marshaller;
    }

    @Bean
    public AuthenticationService wsdlAuthentication(Jaxb2Marshaller marshaller) {
        AuthenticationService client = new AuthenticationService();
        client.setDefaultUri(url);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

    @Bean
    public ProfessorScheduleService professorScheduleService(Jaxb2Marshaller marshaller) {
        ProfessorScheduleService client = new ProfessorScheduleService();
        client.setDefaultUri(url);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

    @Bean
    public StudentPerfilService studentPerfilService(Jaxb2Marshaller marshaller) {
        StudentPerfilService client = new StudentPerfilService();
        client.setDefaultUri(url);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

    @Bean
    public ScheduleService scheduleLanguageService(Jaxb2Marshaller marshaller) {
        ScheduleService client = new ScheduleService();
        client.setDefaultUri(url);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

    @Bean
    public AssiduityService assiduityService(Jaxb2Marshaller marshaller) {
        AssiduityService client = new AssiduityService();
        client.setDefaultUri(url);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

    @Bean
    public GradesService gradesService(Jaxb2Marshaller marshaller) {
        GradesService client = new GradesService();
        client.setDefaultUri(url);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

    @Bean
    public ATMService atmService(Jaxb2Marshaller marshaller) {
        ATMService client = new ATMService();
        client.setDefaultUri(url);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

    @Bean
    public MenuService menuService(Jaxb2Marshaller marshaller) {
        MenuService client = new MenuService();
        client.setDefaultUri(url);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

    @Bean
    public ExamsService examsService(Jaxb2Marshaller marshaller) {
        ExamsService client = new ExamsService();
        client.setDefaultUri(url);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
