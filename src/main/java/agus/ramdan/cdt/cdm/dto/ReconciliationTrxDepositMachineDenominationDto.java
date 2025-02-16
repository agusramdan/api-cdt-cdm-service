package agus.ramdan.cdt.cdm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReconciliationTrxDepositMachineDenominationDto implements Serializable {
    private BigDecimal denomination;
    private Integer quantity;
    private BigDecimal amount;
    private String type;
}
