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
    private String qr_code;
    private String branch_code;
    private String terminal_id;
    private String terminal_info;
    private String reff_id;
    private String pickup_date;
    private Integer total_pieces;
    private String amount;
    private List<CdmPickupDenomDTO> denomination = new ArrayList<>();
}
