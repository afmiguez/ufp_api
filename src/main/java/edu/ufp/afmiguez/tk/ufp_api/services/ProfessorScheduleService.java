package edu.ufp.afmiguez.tk.ufp_api.services;

import edu.ufp.afmiguez.tk.ufp_api.Utils;
import edu.ufp.afmiguez.tk.ufp_api.models.Schedule;
import edu.ufp.afmiguez.tk.ufp_api.models.responses.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import ufp.wsdl.Docente;
import ufp.wsdl.DocenteResponse;
import ufp.wsdl.Docentes;
import ufp.wsdl.DocentesResponse;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProfessorScheduleService extends GenericService {


    @Value("${wsdl.action.docentes}")
    private String docentesAction = "http://tempuri.org/docentes";

    @Value("${wsdl.action.docente}")
    private String docenteAction = "http://tempuri.org/docente";

    public ResponseJSON getDocentes() {

        Docentes docentes = new Docentes();
        DocentesResponse response = (DocentesResponse) getWebServiceTemplate()
                .marshalSendAndReceive(this.getUrl(), docentes
                        , new SoapActionCallback(docentesAction)
                );
        try {
            return ResponseJSON.createResponse(Utils.getValue(response.getDocentesResult(), DocentesJSON.class));
        } catch (IOException e) {
            return ResponseJSON.createError("Error at parsing to JSON");
        }
    }

    public ResponseJSON getDocenteInformation(String initial){
        Docente docente = new Docente();
        docente.setSigla(initial);
        DocenteResponse docenteResponse = (DocenteResponse) getWebServiceTemplate()
                .marshalSendAndReceive(this.getUrl(), docente
                        , new SoapActionCallback(docenteAction)
                );
        /**
         * TODO check when DocenteResponse is invalid
         */
        /*

         */
        DocenteJSON docenteJSON1 = new DocenteJSON();
        docenteJSON1.setDocente(docenteResponse.getDocenteResult());

        Document doc= Jsoup.parse(docenteResponse.getDocenteResult());
        String name=doc.getElementsByTag("b").text();

        String email="";

        LocalDate last_update=null;
        List<Element> elements=doc.getElementsByTag("p");
        for(Element schedule:elements){
            if(schedule.wholeText().contains("Correio Electrónico:")) {
                email=schedule.wholeText().split("Correio Electrónico:")[1].trim();
                if(email.contains(". ")){
                    String[] emailSplit = email.split(". ");
                    email=emailSplit[0];
                }
                if(email.endsWith(".")){
                    email=email.substring(0,email.length()-1);
                }
//                break;
            }
            if(schedule.wholeText().contains("Última actualização: ")){
                String date=schedule.wholeText().split("Última actualização: ")[1].trim();
                last_update=LocalDate.parse(date);
            }
        }

        List<Schedule> schedules=new ArrayList<>();
        List<Element> schdeulesHTML=doc.getElementsByTag("li");
        for(Element schedule:schdeulesHTML){
            String[] scheduleArr=schedule.wholeText().split("das");
            DayOfWeek dayOfWeek=translateDays.get(scheduleArr[0].trim());
            String[] hoursArr=scheduleArr[1].split("às");
            LocalTime startHour=LocalTime.parse(hoursArr[0].trim());
            LocalTime endHour=LocalTime.parse(hoursArr[1].trim());
            schedules.add(new Schedule(dayOfWeek,startHour,endHour));
        }

        DocenteDetailsJSON docenteDetailsJSON=new DocenteDetailsJSON();
        docenteDetailsJSON.setEmail(email);
        docenteDetailsJSON.setName(name);
        docenteDetailsJSON.setSchedule(schedules);
        docenteDetailsJSON.setLast_update(last_update);

        return ResponseJSON.createResponse(docenteDetailsJSON);
    }

    public ResponseJSON getDocenteInformation(DocenteJSON docenteJSON) {
        Docente docente = new Docente();
        docente.setSigla(docenteJSON.getSigla());
        DocenteResponse docenteResponse = (DocenteResponse) getWebServiceTemplate()
                .marshalSendAndReceive(this.getUrl(), docente
                        , new SoapActionCallback(docenteAction)
                );
        /**
         * TODO check when DocenteResponse is invalid
         */
        //return Optional.of(Utils.getValue(docenteResponse.getDocenteResult(),DocenteJSON.class));
        DocenteJSON docenteJSON1 = new DocenteJSON();
        docenteJSON1.setDocente(docenteResponse.getDocenteResult());
        return ResponseJSON.createResponse(docenteJSON1);

    }

    private static Map<String, DayOfWeek> translateDays=new HashMap<>();
    static{
        translateDays.put("Segunda", DayOfWeek.MONDAY);
        translateDays.put("Terça", DayOfWeek.TUESDAY);
        translateDays.put("Quarta", DayOfWeek.WEDNESDAY);
        translateDays.put("Quinta", DayOfWeek.THURSDAY);
        translateDays.put("Sexta", DayOfWeek.FRIDAY);
        translateDays.put("Sábado", DayOfWeek.SATURDAY);
        translateDays.put("Domingo", DayOfWeek.SUNDAY);

    }
}
