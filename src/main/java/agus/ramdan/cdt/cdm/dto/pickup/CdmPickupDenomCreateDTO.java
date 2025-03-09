package agus.ramdan.cdt.cdm.dto.pickup;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CdmPickupDenomCreateDTO implements Serializable {
    @NotNull(message = "denom cannot be null.")
    @Positive(message = "denom must be positive value.")
    private Integer pieces;
    @NotNull(message = "denom cannot be null.")
    @Positive(message = "denom must be positive value.")
    private Integer denom;

}
