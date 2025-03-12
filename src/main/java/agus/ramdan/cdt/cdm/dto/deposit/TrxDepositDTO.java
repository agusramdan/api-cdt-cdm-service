package agus.ramdan.cdt.cdm.dto.deposit;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrxDepositDTO implements Serializable {
    private String id;
    private String username;
    @JsonProperty("terminal_id")
    private String terminalId;
    @JsonProperty("trx_date")
    private LocalDate cdmTrxDate;
    @JsonProperty("trx_time")
    private LocalTime cdmTrxTime;
    private String branch;
    @JsonProperty("trx_id")
    private String cdmTrxNo;
    private String amount;
    private String status;
    private List<TrxDepositDenDTO> denominations;
}
