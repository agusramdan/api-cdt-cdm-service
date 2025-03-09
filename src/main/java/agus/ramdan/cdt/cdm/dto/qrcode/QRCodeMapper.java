package agus.ramdan.cdt.cdm.dto.qrcode;

import agus.ramdan.cdt.core.trx.controller.dto.qrcode.QRCodeQueryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface QRCodeMapper {
    @Mapping(target = "branch_code", source = "branch.code")
    @Mapping(target = "branch_name", source = "branch.name")
    @Mapping(target = "username", expression = "java(source.getVendorCrew() != null && source.getVendorCrew().getUsername() != null ? source.getVendorCrew().getUsername() : (source.getUser() != null ? source.getUser().getUsername() : null))")
    @Mapping(target = "terminalId", source = "machine.code")
    QRCodeCDMResponse fromQRCodeQueryDTO(QRCodeQueryDTO source);

}
