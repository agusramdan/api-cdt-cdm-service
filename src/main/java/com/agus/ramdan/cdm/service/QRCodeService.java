package com.agus.ramdan.cdm.service;

import com.agus.ramdan.cdm.dto.QRCodeMapper;
import com.agus.ramdan.cdm.dto.QRCodeRequest;
import com.agus.ramdan.cdm.dto.QRCodeResponse;
import com.agus.ramdan.cdm.exception.BadRequestException;
import com.agus.ramdan.cdm.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QRCodeService {
    private final QRCodeMapper mapper;
    private final CoreClient coreClient;

    public QRCodeResponse createCode(QRCodeRequest request) {
//        var qrCode = mapper.fromQRCodeRequest(request);
//        qrCode = this.createCode(qrCode);
//        return mapper.toQRCodeResponse(qrCode);
        return new QRCodeResponse();
    }
    public Optional<QRCodeResponse> findByCode(String code) {
//        return repository.findByCode(code).map(mapper::toQRCodeResponse);
        return null;
    }
    public QRCodeResponse validateCode(String code) {
        return coreClient.validateCode(code);
    }

    public QRCodeResponse usedCode(String code) throws ResourceNotFoundException, BadRequestException {
//        val qrCode = repository.findByCode(code).orElseThrow(()->new ResourceNotFoundException("QR Code Not Found"));
//        if (Boolean.TRUE.equals(qrCode.getIs_used())){
//            throw new BadRequestException("QR Code Already used");
//        }
//        qrCode.setIs_used(Boolean.TRUE);
//        repository.save(qrCode);
          val response = new QRCodeResponse();
//        BeanUtils.copyNonNullProperties(qrCode,response);

        return response;
    }
}
