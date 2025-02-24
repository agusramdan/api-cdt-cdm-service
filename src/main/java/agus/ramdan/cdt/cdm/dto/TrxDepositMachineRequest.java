package agus.ramdan.cdt.cdm.dto;

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
public class TrxDepositMachineRequest implements Serializable {
    @AssertTrue(message = "invalid signature")
    @JsonIgnore
    public boolean isValidSignature() {
        val raw = String.format("%s##%s##%s##%s##%s",
                StringUtils.defaultString(qr_code),
                StringUtils.defaultString(machine_deposit_code),
//                StringUtils.defaultString(machine_deposit_sn),
                StringUtils.defaultString(cdm_trx_no),
                StringUtils.defaultString(trx_date),
                StringUtils.defaultString(amount)
                );
        val signature = DigestUtils.sha1Hex(raw);
        if (signature.equals(this.signature)) return true;
        log.error("Raw: {}, Signature {}",raw,signature);
        return false;
    }
    @Schema(description="sha1Hex(qr_code##machine_deposit_code##machine_deposit_sn##cdm_trx_no##trx_date##amount)")
    @NotNull(message = "QR Code cannot be null")
    private String signature;

    @NotNull(message = "QR Code cannot be null")
    @Size(min = 20, max = 20, message = "QR Code must 20 characters.")
    @ValidTokenQR
    private String qr_code;

//    @AssertTrue(message = "Either machine_deposit_code or machine_deposit_sn must be provided.")
//    @JsonIgnore
//    public boolean isValidMachineDepositInfo() {
//        return StringUtils.isNotBlank(machine_deposit_code)||StringUtils.isNotBlank(machine_deposit_sn);
//    }
//    private String branch_id;
    @NotNull(message = "branch_code cannot be null.")
    private String branch_code;
//    private String branch_name;

    @NotNull(message = "machine_deposit_code cannot be null.")
    private String machine_deposit_code;
//    private String machine_deposit_sn;
    private String cdm_trx_no;

    @NotNull(message = "trx_date cannot be null.")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}$",
            message = "Invalid trx_date format. Expected: yyyy-MM-dd'T'HH:mm:ss")
    private String trx_date;

    @NotNull(message = "amount cannot be null.")
    @Positive(message = "amount must be positive value.")
    @Digits(integer = 10, fraction = 2, message = "Invalid amount format. Expected: #0.00")
    private String amount;

    @Valid
    @NotNull(message = "denominations cannot be null.")
    @NotEmpty(message = "denominations cannot be empty.")
    private List<TrxDepositMachineDenominationRequest> denominations = new ArrayList<>();
}
