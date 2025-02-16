package agus.ramdan.cdt.cdm.service;

import agus.ramdan.base.exception.BadRequestException;
import agus.ramdan.base.exception.ResourceNotFoundException;
import agus.ramdan.cdt.cdm.domain.ServiceTransaction;
import agus.ramdan.cdt.cdm.dto.qrcode.QRCodeCDMRequest;
import agus.ramdan.cdt.cdm.dto.qrcode.QRCodeCDMResponse;
import agus.ramdan.cdt.cdm.dto.qrcode.QRCodeMapper;
import agus.ramdan.cdt.core.trx.controller.client.QRCodeClient;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QRCodeService {
    private final QRCodeMapper mapper;
    private final CoreClient coreClient;
    private final QRCodeClient client;

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
        val queryDTO = client.getByCode(code);
        return coreClient.validateCode(code);
    }
    public ServiceTransaction createServiceTransaction(ServiceTransaction code) {

        return coreClient.getServiceTransaction(code.getToken());
    }


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
