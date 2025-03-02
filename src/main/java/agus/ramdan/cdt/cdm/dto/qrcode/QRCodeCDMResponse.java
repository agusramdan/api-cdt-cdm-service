package agus.ramdan.cdt.cdm.dto.qrcode;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class QRCodeCDMResponse implements Serializable {
    private String code;
    private String username;
    private String type;
    private String branch_code;
    private String branch_name;
    private String expired_time ;
}
