package agus.ramdan.cdt.cdm.dto.deposit;

import agus.ramdan.cdt.core.trx.controller.dto.deposit.TrxDepositCreateDTO;
import agus.ramdan.cdt.core.trx.controller.dto.deposit.TrxDepositQueryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CdmDepositMapper {

    @Mapping(target = "machine.code", source = "terminalId")
    @Mapping(target = "machineInfo",source = "branch")
    TrxDepositCreateDTO toTrxDepositCreateDTO(CdmDepositCreateDTO request);

    @Mapping(target = "terminalId", source = "machine.code")
    @Mapping(target = "branch",source = "machineInfo")
    CdmDepositDTO toTrxDepositDTO(TrxDepositQueryDTO request);
}
