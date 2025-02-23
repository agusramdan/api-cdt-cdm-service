package agus.ramdan.cdt.cdm.service;

import agus.ramdan.base.exception.BadRequestException;
import agus.ramdan.base.exception.ResourceNotFoundException;
import agus.ramdan.cdt.cdm.dto.qrcode.QRCodeCDMRequest;
import agus.ramdan.cdt.cdm.dto.qrcode.QRCodeCDMResponse;
import agus.ramdan.cdt.cdm.dto.qrcode.QRCodeMapper;
import agus.ramdan.cdt.core.trx.controller.client.QRCodeQueryClient;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QRCodeService {
    private final QRCodeMapper mapper;
    private final QRCodeQueryClient client;

    public QRCodeCDMResponse createCode(QRCodeCDMRequest request) {
//        var qrCode = mapper.fromQRCodeRequest(request);
//        qrCode = this.createCode(qrCode);
//        return mapper.toQRCodeResponse(qrCode);
        return new QRCodeCDMResponse();
    }
    public Optional<QRCodeCDMResponse> findByCode(String code) {

//        return repository.findByCode(code).map(mapper::toQRCodeResponse);
        return null;
    }
    public QRCodeCDMResponse validateCode(String code) {
        return Try.of(() -> {
            val queryDTO = client.getByCode(code);
            val response = mapper.fromQRCodeQueryDTO(queryDTO);
            // Additional logic for usedCode
            return response;
        }).getOrElseThrow(ex -> {
            if (ex instanceof ResourceNotFoundException) {
                return (ResourceNotFoundException) ex;
            } else if (ex instanceof BadRequestException) {
                return (BadRequestException) ex;
            } else {
                return new RuntimeException(ex);
            }
        });
    }
//    public ServiceTransaction createServiceTransaction(ServiceTransaction code) {
//
//        return coreClient.getServiceTransaction(code.getToken());
//    }


    public QRCodeCDMResponse usedCode(String code) throws ResourceNotFoundException, BadRequestException {
//        val qrCode = repository.findByCode(code).orElseThrow(()->new ResourceNotFoundException("QR Code Not Found"));
//        if (Boolean.TRUE.equals(qrCode.getIs_used())){
//            throw new BadRequestException("QR Code Already used");
//        }
//        qrCode.setIs_used(Boolean.TRUE);
//        repository.save(qrCode);
          val response = new QRCodeCDMResponse();
//        BeanUtils.copyNonNullProperties(qrCode,response);

        return response;
    }
}
