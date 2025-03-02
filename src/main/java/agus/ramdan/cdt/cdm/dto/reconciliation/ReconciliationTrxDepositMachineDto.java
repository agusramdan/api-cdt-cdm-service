package agus.ramdan.cdt.cdm.dto.reconciliation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReconciliationTrxDepositMachineDto implements Serializable {
    private String qr_code;
    private String cdm_trx_no;
    private String trx_date;
    private String trx_no;
    private String amount;
    private String status;
    private List<ReconciliationTrxDepositMachineDenominationDto> denominations;
}
