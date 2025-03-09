package agus.ramdan.cdt.cdm.dto.pickup;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CdmPickupDenomDTO implements Serializable {
    private String id;
    private Integer pieces;
    private Integer denom;
}
