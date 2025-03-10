package agus.ramdan.cdt.cdm.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
@Builder
@AllArgsConstructor
@Getter
public class TrxDepositMachineResponse implements Serializable {
    private String id;
    private String qr_code;
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
    private List<TrxDepositMachineDenominationDto> denominations;
}
