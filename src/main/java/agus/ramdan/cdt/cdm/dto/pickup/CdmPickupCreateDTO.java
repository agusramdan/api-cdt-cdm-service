package agus.ramdan.cdt.cdm.dto.pickup;

import agus.ramdan.cdt.cdm.utils.ValidTokenQR;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.val;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
public class CdmPickupCreateDTO implements Serializable {
    @AssertTrue(message = "invalid signature")
    @JsonIgnore
    public boolean isValidSignature() {
        val raw = String.format("%s##%s##%s##%s##%s",
                StringUtils.defaultString(qr_code),
                StringUtils.defaultString(terminal_id),
                StringUtils.defaultString(reff_id),
                StringUtils.defaultString(pickup_date),
                StringUtils.defaultString(amount)
        );
        val signature = DigestUtils.sha1Hex(raw);
        if (signature.equals(this.signature)) return true;
        log.error("Raw: {}, Signature {}", raw, signature);
        return false;
    }

    @Schema(description = "sha1Hex(qr_code##machine_deposit_code##machine_deposit_sn##cdm_trx_no##trx_date##amount)")
    @NotNull(message = "QR Code cannot be null")
    private String signature;

    @NotNull(message = "QR Code cannot be null")
    @Size(min = 20, max = 20, message = "QR Code must 20 characters.")
    @ValidTokenQR
    private String qr_code;

    @NotNull(message = "terminal_id cannot be null.")
    private String terminal_id;
    private String terminal_info;

    @NotNull(message = "reff_id cannot be null.")
    private String reff_id;

    @NotNull(message = "pickup_date cannot be null.")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}$",
            message = "Invalid pickup_date format. Expected: yyyy-MM-dd'T'HH:mm:ss")
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
