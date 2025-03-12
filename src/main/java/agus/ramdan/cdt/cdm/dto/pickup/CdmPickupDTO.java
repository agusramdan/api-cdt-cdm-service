package agus.ramdan.cdt.cdm.dto.pickup;

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
    private String terminalId;
    private String terminalInfo;
    private String reffId;
    private String pickupDate;
    private Integer totalPieces;
    private String amount;
    private List<CdmPickupDenomDTO> denomination = new ArrayList<>();
}
