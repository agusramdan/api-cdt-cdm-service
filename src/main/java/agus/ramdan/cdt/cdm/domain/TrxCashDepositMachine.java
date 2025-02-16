package agus.ramdan.cdt.cdm.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Schema
@Builder
public class TrxCashDepositMachine {
    private String id;
    private String token;
    private String signature;
    private String status;

    private String service_transaction_id;
    private String service_transaction_no;

    private String service_product_id;
    private String service_product_code;
    private String service_product_name;

    private String cdm_trx_no;

    private LocalDateTime cdm_trx_date;
    private LocalDateTime trx_date;

    private BigDecimal amount;
    private List<TrxCashDepositMachineDenomination> denominations;

}