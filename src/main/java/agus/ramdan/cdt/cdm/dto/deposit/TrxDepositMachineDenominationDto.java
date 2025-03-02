package agus.ramdan.cdt.cdm.dto.deposit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrxDepositMachineDenominationDto implements Serializable {
    private String id;
    private BigDecimal denomination;
    private Integer quantity;
    private BigDecimal amount;
    private String type;
}
