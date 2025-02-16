package agus.ramdan.cdt.cdm.dto.qrcode;

import agus.ramdan.cdt.core.trx.controller.dto.qrcode.QRCodeQueryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface QRCodeMapper {
    QRCodeCDMResponse fromQRCodeQueryDTO(QRCodeQueryDTO source);
//    QRCode fromQRCodeRequest(QRCodeRequest request);
//    QRCodeResponse toQRCodeResponse(QRCode qrCode);

}
