package agus.ramdan.cdt.cdm.dto.deposit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrxDepositMachineDto implements Serializable {
    private String id;
    private String token;
    private String cdm_trx_no;
    private String trx_date;
    private String trx_no;
    private String amount;
    private String status;
    private List<TrxDepositMachineDenominationDto> denominations;
}
