package agus.ramdan.cdt.cdm.dto.deposit;

import agus.ramdan.cdt.core.trx.controller.dto.deposit.TrxDepositCreateDTO;
import agus.ramdan.cdt.core.trx.controller.dto.deposit.TrxDepositDenQueryDTO;
import agus.ramdan.cdt.core.trx.controller.dto.deposit.TrxDepositQueryDTO;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CdmDepositMapper {

    @Mapping(target = "machine.code", source = "terminalId")
    @Mapping(target = "machineInfo",source = "branch")
    TrxDepositCreateDTO toTrxDepositCreateDTO(CdmDepositCreateDTO request);

    @Mapping(target = "terminalId", source = "machine.code")
    @Mapping(target = "branch",source = "machineInfo")
    @Mapping(target = "denominations", source = "denominations", qualifiedByName = "mapListToCdmDepositDenDTO")
    CdmDepositDTO toTrxDepositDTO(TrxDepositQueryDTO request);

    @Named("mapToCdmDepositDenDTO")
    CdmDepositDenDTO mapToCdmDepositDenDTO(TrxDepositDenQueryDTO entity);

    @IterableMapping(qualifiedByName = "mapToCdmDepositDenDTO")
    @Named("mapListToCdmDepositDenDTO")
    List<CdmDepositDenDTO> mapListToCdmDepositDenDTO(List<TrxDepositDenQueryDTO> entities);
}
