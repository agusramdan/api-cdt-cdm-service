package agus.ramdan.cdt.cdm.dto.reconciliation;

import agus.ramdan.cdt.cdm.dto.deposit.TrxDepositMachineRequest;
import agus.ramdan.cdt.cdm.dto.deposit.TrxDepositMachineResponse;
import agus.ramdan.cdt.core.trx.controller.dto.deposit.TrxDepositCreateDTO;
import agus.ramdan.cdt.core.trx.controller.dto.deposit.TrxDepositQueryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ReconciliationMapper {
//    TrxCashDepositMachine trxDepositMachineDtoToTrxDepositMachine(TrxDepositMachineDto trxDepositMachineDto);
//
//    TrxDepositMachineDto trxDepositMachineToTrxDepositMachineDto(TrxCashDepositMachine trxDepositMachine);
//
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    TrxCashDepositMachine updateTrxDepositMachineFromTrxDepositMachineDto(TrxDepositMachineDto trxDepositMachineDto, @MappingTarget TrxCashDepositMachine trxDepositMachine);
//
//    TrxCashDepositMachineDenomination trxDepositMachineDenominationDtoToTrxDepositMachineDenomination(TrxDepositMachineDenominationDto trxDepositMachineDenominationDto);
//
//    TrxDepositMachineDenominationDto trxDepositMachineDenominationToTrxDepositMachineDenominationDto(TrxCashDepositMachineDenomination trxDepositMachineDenomination);
//
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    TrxCashDepositMachineDenomination updateTrxDepositMachineDenominationFromTrxDepositMachineDenominationDto(TrxDepositMachineDenominationDto trxDepositMachineDenominationDto, @MappingTarget TrxCashDepositMachineDenomination trxDepositMachineDenomination);
//
//    TrxCashDepositMachineDenomination trxDepositMachineDenominationRequestToTrxDepositMachineDenomination(TrxDepositMachineDenominationRequest trxDepositMachineDenominationRequest);
//
//    TrxDepositMachineDenominationRequest trxDepositMachineDenominationToTrxDepositMachineDenominationRequest(TrxCashDepositMachineDenomination trxDepositMachineDenomination);
//
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    TrxCashDepositMachineDenomination updateTrxDepositMachineDenominationFromTrxDepositMachineDenominationRequest(TrxDepositMachineDenominationRequest trxDepositMachineDenominationRequest, @MappingTarget TrxCashDepositMachineDenomination trxDepositMachineDenomination);
//
//    TrxCashDepositMachine trxDepositMachineRequestToTrxDepositMachine(TrxDepositMachineRequest trxDepositMachineRequest);
//
//    TrxDepositMachineRequest toTrxDepositMachineRequest(TrxCashDepositMachine trxDepositMachine);
//
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    TrxCashDepositMachine updateTrxDepositMachineFromTrxDepositMachineRequest(TrxDepositMachineRequest trxDepositMachineRequest, @MappingTarget TrxCashDepositMachine trxDepositMachine);
//
//    TrxCashDepositMachine toTrxCashDepositMachine(TrxDepositMachineResponse trxDepositMachineResponse);
//
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    TrxCashDepositMachine updateTrxDepositMachineFromTrxDepositMachineResponse(TrxDepositMachineResponse trxDepositMachineResponse, @MappingTarget TrxCashDepositMachine trxDepositMachine);
//
//    TrxDepositMachineDto toTrxDepositMachineDto(TrxDepositMachineRequest request);
    ReconciliationDto toReconciliationDto(ReconciliationRequest request);
//    TrxDepositMachineDto toTrxDepositMachineDto(ReconciliationTrxDepositMachineDto request);
//    TrxDepositMachineDenominationDto toTrxDepositMachineDenominationDto(ReconciliationTrxDepositMachineDenominationDto request);

    @Mapping(target = "token",source = "qr_code")
    TrxDepositCreateDTO toTrxDepositCreateDTO(TrxDepositMachineRequest request);

//    @Mapping(target = "qr_code",source = "token")
//    TrxDepositMachineResponse toTrxDepositMachineResponse(TrxCashDepositMachine request);
    @Mapping(target = "qr_code",source = "token")
    TrxDepositMachineResponse toTrxDepositMachineResponse(TrxDepositQueryDTO request);



}
