package agus.ramdan.cdt.cdm.dto.pickup;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CdmPickupRespon implements Serializable {
    @JsonProperty("response_code")
    private String responseCode="200";
    @JsonProperty("response_message")
    private String responseMessage="Pick Up success";
    private CdmPickupResponseData data;
}
