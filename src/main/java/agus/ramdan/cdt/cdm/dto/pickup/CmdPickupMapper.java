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

    @Mapping(target = "signature", source = "signature")
    @Mapping(target = "token", source = "qr_code")
    @Mapping(target = "machine.code", source = "terminal_id")
    @Mapping(target = "machineInfo", source = "terminal_info")
    @Mapping(target = "cdmTrxNo", source = "reff_id")
    @Mapping(target = "cdmTrxDate", source = "pickup_date")
    @Mapping(target = "totalPieces", source = "total_pieces")
    @Mapping(target = "amount", source = "amount")
    @Mapping(target = "denominations", source = "denomination")
    TrxPickupCreateDTO toTrxPickupCreateDTO(CdmPickupCreateDTO request);

    @Mapping(target = "quantity", source = "pieces")
    @Mapping(target = "denomination", source = "denom")
    TrxPickupDenomCreateDTO toTrxPickupDenomCreateDTO(CdmPickupDenomCreateDTO request);

    @Mapping(target = "terminal_info", source = "machineInfo")
    @Mapping(target = "terminal_id", source = "machine.code")
    @Mapping(target = "reff_id", source = "cdmTrxNo")
    @Mapping(target = "pickup_date", source = "cdmTrxDate")
//    @Mapping(target = "service_product_name",source = "trxDate")
//    @Mapping(target = "amount",source = "amount")
    @Mapping(target = "denomination", source = "denominations")
    CdmPickupDTO toCdmPickupDTO(TrxPickupQueryDTO request);

    @Mapping(target = "pieces", source = "quantity")
    @Mapping(target = "denom", source = "denomination")
    CdmPickupDenomDTO toTrxPickupDenomCreateDTO(TrxPickupDenomQueryDTO request);

}
