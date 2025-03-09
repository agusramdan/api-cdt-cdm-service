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
    private String type;
    private String branch_code;
    private String branch_name;
    private String expired_time;
    @JsonProperty("terminal_id")
    private String terminalId;
}
