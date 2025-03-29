package agus.ramdan.cdt.cdm.dto.pickup;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CdmPickupResponseData implements Serializable {
    @JsonProperty("reffid")
    private String reffId;
}
