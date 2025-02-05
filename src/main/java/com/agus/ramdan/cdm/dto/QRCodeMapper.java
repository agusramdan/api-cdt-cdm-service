package com.agus.ramdan.cdm.dto;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface QRCodeMapper {
//    QRCode fromQRCodeRequest(QRCodeRequest request);
//    QRCodeResponse toQRCodeResponse(QRCode qrCode);

}
