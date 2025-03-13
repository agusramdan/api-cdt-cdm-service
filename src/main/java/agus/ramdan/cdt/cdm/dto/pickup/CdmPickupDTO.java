package agus.ramdan.cdt.cdm.dto.pickup;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CdmPickupDTO implements Serializable {
    private String id;

    private String branchCode;
    @JsonProperty("terminal_id")
    private String terminalId;
    @JsonProperty("terminal_info")
    private String terminalInfo;
    @JsonProperty("reff_id")
    private String reffId;

    private String pickupDate;
    private Integer totalPieces;
    private String amount;
    private List<CdmPickupDenDTO> denomination = new ArrayList<>();
}
