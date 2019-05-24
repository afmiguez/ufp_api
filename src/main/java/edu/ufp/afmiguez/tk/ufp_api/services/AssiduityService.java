package edu.ufp.afmiguez.tk.ufp_api.services;

import edu.ufp.afmiguez.tk.ufp_api.Utils;
import edu.ufp.afmiguez.tk.ufp_api.models.responses.AssiduityJSON;
import edu.ufp.afmiguez.tk.ufp_api.models.responses.ResponseJSON;
import edu.ufp.afmiguez.tk.ufp_api.models.responses.ResponseJSONString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import ufp.wsdl.Assiduitylanguage;
import ufp.wsdl.AssiduitylanguageResponse;

import java.io.IOException;

public class AssiduityService extends GenericService {
    @Value("${wsdl.action.assiduitylanguage}")
    private String assiduityLanguageAction;

    public ResponseJSON getAssiduityLanguage(String token, String language){
        Assiduitylanguage request=new Assiduitylanguage();
        request.setToken(token);
        request.setLanguage(language);
        AssiduitylanguageResponse response=(AssiduitylanguageResponse)getWebServiceTemplate()
                .marshalSendAndReceive(this.getUrl(),request,new SoapActionCallback(assiduityLanguageAction));
//        this.logger.info(response.getAssiduitylanguageResult());

//        String jsonTest="{\"assiduity\":[{\"AnoLectivo\": \"2018/19\", \"Unidade\": \"Advanced Databases\", \"ECTS\": \"6\", \"Tipo\": \"PL\", \"Turma\": \"DNW\", \"Assiduidade\": \"91\"},{\"AnoLectivo\": \"2018/19\", \"Unidade\": \"Advanced Databases\", \"ECTS\": \"6\", \"Tipo\": \"TP\", \"Turma\": \"GBO\", \"Assiduidade\": \"91\"}, {\"AnoLectivo\": \"2018/19\", \"Unidade\": \"Artificial Intelligence\", \"ECTS\": \"6\", \"Tipo\": \"PL\", \"Turma\": \"DOB\", \"Assiduidade\": \"81\"}, {\"AnoLectivo\": \"2018/19\", \"Unidade\": \"Artificial Intelligence\", \"ECTS\": \"6\", \"Tipo\": \"TP\", \"Turma\": \"GBM\", \"Assiduidade\": \"81\"}, {\"AnoLectivo\": \"2018/19\", \"Unidade\": \"Human Computer Interaction\", \"ECTS\": \"6\", \"Tipo\": \"PL\", \"Turma\": \"DNY\", \"Assiduidade\": \"100\"}, {\"AnoLectivo\": \"2018/19\", \"Unidade\": \"Human Computer Interaction\", \"ECTS\": \"6\", \"Tipo\": \"TP\", \"Turma\": \"GBL\", \"Assiduidade\": \"87\"}, {\"AnoLectivo\": \"2018/19\", \"Unidade\": \"Mobile Applications Programming\", \"ECTS\": \"6\", \"Tipo\": \"PL\", \"Turma\": \"DNZ\", \"Assiduidade\": \"53\"}, {\"AnoLectivo\": \"2018/19\", \"Unidade\": \"Mobile Applications Programming\", \"ECTS\": \"6\", \"Tipo\": \"TP\", \"Turma\": \"GBK\", \"Assiduidade\": \"66\"}, {\"AnoLectivo\": \"2018/19\", \"Unidade\": \"Mobile Computing\", \"ECTS\": \"6\", \"Tipo\": \"PL\", \"Turma\": \"DNX\", \"Assiduidade\": \"62\"}, {\"AnoLectivo\": \"2018/19\", \"Unidade\": \"Mobile Computing\", \"ECTS\": \"6\", \"Tipo\": \"TP\", \"Turma\": \"GBN\", \"Assiduidade\": \"93\"}, {\"AnoLectivo\": \"2018/19\", \"Unidade\": \"Mobile Networks and Services I\", \"ECTS\": \"6\", \"Tipo\": \"PL\", \"Turma\": \"DOA\", \"Assiduidade\": \"100\"}, {\"AnoLectivo\": \"2018/19\", \"Unidade\": \"Mobile Networks and Services I\", \"ECTS\": \"6\", \"Tipo\": \"TP\", \"Turma\": \"GBI\", \"Assiduidade\": \"100\"}, {\"AnoLectivo\": \"2018/19\", \"Unidade\": \"Mobile Networks and Services II\", \"ECTS\": \"6\", \"Tipo\": \"PL\", \"Turma\": \"DOE\", \"Assiduidade\": \"83\"}, {\"AnoLectivo\": \"2018/19\", \"Unidade\": \"Mobile Networks and Services II\", \"ECTS\": \"6\", \"Tipo\": \"TP\", \"Turma\": \"GBH\", \"Assiduidade\": \"83\"}, {\"AnoLectivo\": \"2018/19\", \"Unidade\": \"Security and Computer Audit\", \"ECTS\": \"6\", \"Tipo\": \"PL\", \"Turma\": \"DOF\", \"Assiduidade\": \"100\"}, {\"AnoLectivo\": \"2018/19\", \"Unidade\": \"Security and Computer Audit\", \"ECTS\": \"6\", \"Tipo\": \"TP\", \"Turma\": \"GBG\", \"Assiduidade\": \"100\"}, {\"AnoLectivo\": \"2018/19\", \"Unidade\": \"Systems and Networks Project\", \"ECTS\": \"6\", \"Tipo\": \"TP\", \"Turma\": \"DOD\", \"Assiduidade\": \"100\"}, {\"AnoLectivo\": \"2018/19\", \"Unidade\": \"Web Applications Project\", \"ECTS\": \"6\", \"Tipo\": \"PL\", \"Turma\": \"DOC\", \"Assiduidade\": \"93\"}, {\"AnoLectivo\": \"2018/19\", \"Unidade\": \"Web Applications Project\", \"ECTS\": \"6\", \"Tipo\": \"TP\", \"Turma\": \"GBJ\", \"Assiduidade\": \"100\"}]}";
        /**
         * TODO implement the assiduity
         */
        try{
            return ResponseJSON.createResponse(Utils.getValue(response.getAssiduitylanguageResult(), AssiduityJSON.class));
        }catch(IOException ioe){
            return ResponseJSONString.createError("Check your credentials");
        }
    }
}
