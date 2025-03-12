package agus.ramdan.cdt.cdm.dto.deposit;

import agus.ramdan.cdt.cdm.utils.ValidTokenQR;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
public class TrxDepositCommandDTO implements Serializable {
    @NotNull(message = "QR Code cannot be null")
    @Size(min = 20, max = 20, message = "QR Code must 20 characters.")
    @ValidTokenQR
    @JsonProperty("qr_code")
    private String token;
    private String username;
    @JsonProperty("terminal_id")
    private String terminalId;
    @NotNull(message = "QR Code cannot be null")
    @JsonProperty("trx_date")
    private LocalDate cdmTrxDate;
    @NotNull(message = "Invalid trx_time cannot be null.")
    @JsonProperty("trx_time")
    private LocalTime cdmTrxTime;
    private String branch;
    @NotNull(message = "trx_id cannot be null.")
    @JsonProperty("trx_id")
    private String cdmTrxNo;
    @NotNull(message = "amount cannot be null.")
    @Positive(message = "amount must be positive value.")
    @Digits(integer = 10, fraction = 2, message = "Invalid amount format. Expected: #0.00")
    private String amount;
    @Valid
    @NotNull(message = "denominations cannot be null.")
    @NotEmpty(message = "denominations cannot be empty.")
    private List<TrxDepositDenCommandDTO> denominations = new ArrayList<>();
}
