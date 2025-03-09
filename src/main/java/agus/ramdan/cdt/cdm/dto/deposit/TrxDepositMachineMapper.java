package agus.ramdan.cdt.cdm.dto.deposit;

import agus.ramdan.cdt.core.trx.controller.dto.deposit.TrxDepositCreateDTO;
import agus.ramdan.cdt.core.trx.controller.dto.deposit.TrxDepositQueryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TrxDepositMachineMapper {
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
//    ReconciliationDto toReconciliationDto(ReconciliationRequest request);
//    TrxDepositMachineDto toTrxDepositMachineDto(ReconciliationTrxDepositMachineDto request);
//    TrxDepositMachineDenominationDto toTrxDepositMachineDenominationDto(ReconciliationTrxDepositMachineDenominationDto request);

    @Mapping(target = "token", source = "qr_code")
    @Mapping(target = "machine.code", source = "machine_deposit_code")
    @Mapping(target = "cdm_trx_date", source = "trx_date")
    @Mapping(target = "cdm_trx_time", source = "trx_date")
    @Mapping(target = "amount", source = "amount")
        //@Mapping(target = "branch.code",source = "branch_code")
    TrxDepositCreateDTO toTrxDepositCreateDTO(TrxDepositMachineRequest request);

    @Mapping(target = "qr_code", source = "token")
    @Mapping(target = "service_transaction_id", source = "serviceTransaction.id")
    @Mapping(target = "service_transaction_no", source = "serviceTransaction.no")
    @Mapping(target = "service_product_id", source = "serviceProduct.id")
    @Mapping(target = "service_product_code", source = "serviceProduct.code")
    @Mapping(target = "service_product_name", source = "serviceProduct.name")
    @Mapping(target = "machine_deposit_code", source = "machine.code")
    TrxDepositMachineResponse toTrxDepositMachineResponse(TrxDepositQueryDTO request);

}
