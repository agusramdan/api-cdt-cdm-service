package agus.ramdan.cdt.cdm.dto.pickup;

import agus.ramdan.cdt.core.trx.controller.dto.pickup.TrxPickupCreateDTO;
import agus.ramdan.cdt.core.trx.controller.dto.pickup.TrxPickupDenomCreateDTO;
import agus.ramdan.cdt.core.trx.controller.dto.pickup.TrxPickupDenomQueryDTO;
import agus.ramdan.cdt.core.trx.controller.dto.pickup.TrxPickupQueryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CmdPickupMapper {

    @Mapping(target = "machine.code", source = "terminalId")
    @Mapping(target = "machineInfo", source = "terminalInfo")
    @Mapping(target = "cdmTrxNo", source = "reffId")
    @Mapping(target = "cdmTrxDate", source = "pickupDate")
    @Mapping(target = "cdmTrxTime", source = "pickupTime")
    @Mapping(target = "totalPieces", source = "totalPieces")
    @Mapping(target = "amount", source = "amount")
    @Mapping(target = "denominations", source = "denomination")
    TrxPickupCreateDTO toTrxPickupCreateDTO(CdmPickupCreateDTO request);

    @Mapping(target = "quantity", source = "pieces")
    @Mapping(target = "denomination", source = "denom")
    @Mapping(target = "amount", expression = "java(BigDecimal.valueOf(request.getPieces() * request.getDenom()))")
    @Mapping(target = "type", constant = "note")
    TrxPickupDenomCreateDTO toTrxPickupDenomCreateDTO(CdmPickupDenCreateDTO request);

    @Mapping(target = "terminalInfo", source = "machineInfo")
    @Mapping(target = "terminalId", source = "machine.code")
    @Mapping(target = "reffId", source = "cdmTrxNo")
    @Mapping(target = "pickupDate", source = "cdmTrxDate")
    @Mapping(target = "denomination", source = "denominations")
    CdmPickupDTO toCdmPickupDTO(TrxPickupQueryDTO request);

    @Mapping(target = "pieces", source = "quantity")
    @Mapping(target = "denom", source = "denomination")
    CdmPickupDenDTO toTrxPickupDenomCreateDTO(TrxPickupDenomQueryDTO request);

}
