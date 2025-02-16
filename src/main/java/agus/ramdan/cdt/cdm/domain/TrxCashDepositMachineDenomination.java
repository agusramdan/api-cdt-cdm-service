package agus.ramdan.cdt.cdm.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Schema
public class TrxCashDepositMachineDenomination {
    private String id;
    private BigDecimal denomination;
    private Integer quantity;
    private BigDecimal amount;
    private String type;

}