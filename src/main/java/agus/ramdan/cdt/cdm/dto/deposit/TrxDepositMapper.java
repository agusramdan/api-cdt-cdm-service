package agus.ramdan.cdt.cdm.dto.deposit;

import agus.ramdan.cdt.core.trx.controller.dto.deposit.TrxDepositCreateDTO;
import agus.ramdan.cdt.core.trx.controller.dto.deposit.TrxDepositQueryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TrxDepositMapper {

    @Mapping(target = "machine.code", source = "terminalId")
    TrxDepositCreateDTO toTrxDepositCreateDTO(TrxDepositCommandDTO request);

    @Mapping(target = "terminalId", source = "machine.code")
    TrxDepositDTO toTrxDepositDTO(TrxDepositQueryDTO request);
}
