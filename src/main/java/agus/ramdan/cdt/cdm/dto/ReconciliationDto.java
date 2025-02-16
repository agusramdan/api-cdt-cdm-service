package agus.ramdan.cdt.cdm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
public class ReconciliationDto implements Serializable {
    private String machine_deposit_code;
    private String machine_deposit_sn;
    private String trx_date;
    private List<ReconciliationTrxDepositMachineDto> transaction;
}
