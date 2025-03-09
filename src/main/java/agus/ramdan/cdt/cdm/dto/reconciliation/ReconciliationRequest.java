package agus.ramdan.cdt.cdm.dto.reconciliation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.val;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
public class ReconciliationRequest implements Serializable {
    @AssertTrue(message = "invalid signature")
    @JsonIgnore
    public boolean isValidSignature() {
        val raw = String.format("%s##%s##%s##%s##%s",
                StringUtils.defaultString(machine_deposit_code),
                StringUtils.defaultString(machine_deposit_sn),
                StringUtils.defaultString(trx_date)
        );
        val signature = DigestUtils.sha1Hex(raw);
        if (signature.equals(this.signature)) return true;
        log.error("Raw: {}, Signature {}", raw, signature);
        return false;
    }

    @Schema(description = "sha1Hex(qr_code##machine_deposit_code##machine_deposit_sn##cdm_trx_no##trx_date##amount)")
    @NotNull(message = "signature cannot be null")
    private String signature;

    @AssertTrue(message = "Either machine_deposit_code or machine_deposit_sn must be provided.")
    @JsonIgnore
    public boolean isValidMachineDepositInfo() {
        return StringUtils.isNotBlank(machine_deposit_code) || StringUtils.isNotBlank(machine_deposit_sn);
    }

    private String machine_deposit_code;
    private String machine_deposit_sn;

    @NotNull(message = "trx_date cannot be null.")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}",
            message = "Invalid trx_date format. Expected: yyyy-MM-dd")
    private String trx_date;

    private List<ReconciliationTrxDepositMachineDto> transaction;
}
