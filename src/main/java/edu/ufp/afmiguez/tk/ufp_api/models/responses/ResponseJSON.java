package edu.ufp.afmiguez.tk.ufp_api.models.responses;

import lombok.Data;

@Data
public class ResponseJSON {
    private String status;

    public static ResponseJSON createError(String error){
        ResponseJSONString responseJSON=new ResponseJSONString();
        responseJSON.setStatus("Error");
        responseJSON.setMessage(error);
        return responseJSON;
    }

    public static ResponseJSON createResponse(ResponseModel responseModel){
        ResponseJSONObject responseJSONObject=new ResponseJSONObject();
        responseJSONObject.setStatus("Ok");
        responseJSONObject.setMessage(responseModel);
        return responseJSONObject;
    }

    public static ResponseJSON createResponse(String message){
        ResponseJSONString responseJSONString=new ResponseJSONString();
        responseJSONString.setStatus("Ok");
        responseJSONString.setMessage(message);
        return responseJSONString;
    }

}
