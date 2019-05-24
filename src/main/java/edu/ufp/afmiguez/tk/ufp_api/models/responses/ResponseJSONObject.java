package edu.ufp.afmiguez.tk.ufp_api.models.responses;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class ResponseJSONObject extends ResponseJSON{
    private ResponseModel message;

}
