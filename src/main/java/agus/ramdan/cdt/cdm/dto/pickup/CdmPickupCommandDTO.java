package agus.ramdan.cdt.cdm.dto.pickup;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
public class CdmPickupCommandDTO implements Serializable {

    @NotNull(message = "terminal_id cannot be null.")
    @JsonProperty("terminalId")
    private String terminalId;

    @JsonProperty("terminal_info")
    private String terminalInfo;

    @NotNull(message = "reff_id cannot be null.")
    private String reff_id;

    @NotNull(message = "pickup_date cannot be null.")
    private String pickup_date;

    private Integer total_pieces;
    @NotNull(message = "amount cannot be null.")
    @Positive(message = "amount must be positive value.")
    @Digits(integer = 10, fraction = 2, message = "Invalid amount format. Expected: #0.00")
    private String amount;

    @Valid
    @NotNull(message = "denominations cannot be null.")
    @NotEmpty(message = "denominations cannot be empty.")
    private List<CdmPickupDenomCreateDTO> denomination = new ArrayList<>();
}
