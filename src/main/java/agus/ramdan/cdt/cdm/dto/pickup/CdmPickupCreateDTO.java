package agus.ramdan.cdt.cdm.dto.pickup;

import agus.ramdan.base.dto.CoordinateDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
public class CdmPickupCreateDTO implements Serializable {

    @NotNull(message = "terminal_id cannot be null.")
    @JsonProperty("terminal_id")
    private String terminalId;

    @JsonProperty("terminal_info")
    private String terminalInfo;

    @NotNull(message = "reff_id cannot be null.")
    @JsonProperty("reff_id")
    private String reffId;

    @NotNull(message = "pickup_date cannot be null.")
    @JsonProperty("pickup_date")
    private LocalDate pickupDate;

    @NotNull(message = "pickup_date cannot be null.")
    @JsonProperty("pickup_time")
    @JsonFormat(pattern="HH:mm:ss")
    private LocalTime pickupTime;

    @NotNull(message = "amount cannot be null.")
    @Positive(message = "amount must be positive value.")
    private BigDecimal amount;

    @JsonProperty("total_pieces")
    private Integer totalPieces;

    @Valid
    @NotNull(message = "denominations cannot be null.")
    @NotEmpty(message = "denominations cannot be empty.")
    private List<CdmPickupDenCreateDTO> denomination = new ArrayList<>();

    private String username;
    private String branch;
    private CoordinateDTO location;

    @JsonProperty("new_banknote_bag_no")
    private String newBanknoteBagNo;
    @JsonProperty("old_banknote_bag_no")
    private String oldBanknoteBagNo;
    @JsonProperty("otp_used")
    private String otpUsed;

    @JsonProperty("reset_bag_time")
    @NotNull(message = "reset_bag_time cannot null.")
    private LocalDateTime resetBagTime;

    @Positive(message = "total_amount must be positive value.")
    @JsonProperty("total_amount")
    @NotNull(message = "total_amount cannot null.")
    private BigDecimal totalAmount;

    @JsonProperty("last_action")
    private String lastAction;
    @JsonProperty("action_date")
    @NotNull(message = "action_date cannot null.")
    private LocalDate actionDate;

    @JsonProperty("action_start_time")
    @JsonFormat(pattern="HH:mm:ss")
    @NotNull (message = "action_start_time cannot null.")
    private LocalTime actionStartTime;

    @JsonProperty("action_end_time")
    @JsonFormat(pattern="HH:mm:ss")
    @NotNull (message = "action_end_time cannot null.")
    private LocalTime actionEndTime;

    @PositiveOrZero(message = "total_amount_setor must be positive or Zero value.")
    @JsonProperty("total_amount_setor")
    private BigDecimal totalAmountSetor;

    @PositiveOrZero(message = "deposit_upload_success must be positive or Zero value.")
    @JsonProperty("deposit_upload_success")
    private BigDecimal depositUploadSuccess;

    @PositiveOrZero(message = "deposit_upload_fail must be positive or Zero value.")
    @JsonProperty("deposit_upload_fail")
    private BigDecimal depositUploadFail;

    private String requestid;
}
