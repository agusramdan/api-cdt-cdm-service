package agus.ramdan.cdt.cdm.dto;

import agus.ramdan.cdt.cdm.domain.TrxCashDepositMachine;
import agus.ramdan.cdt.cdm.domain.TrxCashDepositMachineDenomination;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TrxDepositMachineMapper {
    TrxCashDepositMachine trxDepositMachineDtoToTrxDepositMachine(TrxDepositMachineDto trxDepositMachineDto);

    TrxDepositMachineDto trxDepositMachineToTrxDepositMachineDto(TrxCashDepositMachine trxDepositMachine);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TrxCashDepositMachine updateTrxDepositMachineFromTrxDepositMachineDto(TrxDepositMachineDto trxDepositMachineDto, @MappingTarget TrxCashDepositMachine trxDepositMachine);

    TrxCashDepositMachineDenomination trxDepositMachineDenominationDtoToTrxDepositMachineDenomination(TrxDepositMachineDenominationDto trxDepositMachineDenominationDto);

    TrxDepositMachineDenominationDto trxDepositMachineDenominationToTrxDepositMachineDenominationDto(TrxCashDepositMachineDenomination trxDepositMachineDenomination);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TrxCashDepositMachineDenomination updateTrxDepositMachineDenominationFromTrxDepositMachineDenominationDto(TrxDepositMachineDenominationDto trxDepositMachineDenominationDto, @MappingTarget TrxCashDepositMachineDenomination trxDepositMachineDenomination);

    TrxCashDepositMachineDenomination trxDepositMachineDenominationRequestToTrxDepositMachineDenomination(TrxDepositMachineDenominationRequest trxDepositMachineDenominationRequest);

    TrxDepositMachineDenominationRequest trxDepositMachineDenominationToTrxDepositMachineDenominationRequest(TrxCashDepositMachineDenomination trxDepositMachineDenomination);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TrxCashDepositMachineDenomination updateTrxDepositMachineDenominationFromTrxDepositMachineDenominationRequest(TrxDepositMachineDenominationRequest trxDepositMachineDenominationRequest, @MappingTarget TrxCashDepositMachineDenomination trxDepositMachineDenomination);

    TrxCashDepositMachine trxDepositMachineRequestToTrxDepositMachine(TrxDepositMachineRequest trxDepositMachineRequest);

    TrxDepositMachineRequest toTrxDepositMachineRequest(TrxCashDepositMachine trxDepositMachine);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TrxCashDepositMachine updateTrxDepositMachineFromTrxDepositMachineRequest(TrxDepositMachineRequest trxDepositMachineRequest, @MappingTarget TrxCashDepositMachine trxDepositMachine);

    TrxCashDepositMachine toTrxCashDepositMachine(TrxDepositMachineResponse trxDepositMachineResponse);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TrxCashDepositMachine updateTrxDepositMachineFromTrxDepositMachineResponse(TrxDepositMachineResponse trxDepositMachineResponse, @MappingTarget TrxCashDepositMachine trxDepositMachine);

    TrxDepositMachineDto toTrxDepositMachineDto(TrxDepositMachineRequest request);
    ReconciliationDto toReconciliationDto(ReconciliationRequest request);
    TrxDepositMachineDto toTrxDepositMachineDto(ReconciliationTrxDepositMachineDto request);
    TrxDepositMachineDenominationDto toTrxDepositMachineDenominationDto(ReconciliationTrxDepositMachineDenominationDto request);

    @Mapping(target = "token",source = "qr_code")
    TrxCashDepositMachine toTrxDepositMachine(TrxDepositMachineRequest request);

    @Mapping(target = "qr_code",source = "token")
    TrxDepositMachineResponse toTrxDepositMachineResponse(TrxCashDepositMachine request);

}
