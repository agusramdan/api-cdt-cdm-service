package agus.ramdan.cdt.cdm.dto.qrcode;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QRCodeCDMResponse implements Serializable {
    private String code;
    private String username;
    @JsonProperty("account_type")
    private String accountType;
    private String branch;
}
