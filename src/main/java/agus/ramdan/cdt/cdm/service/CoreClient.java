package agus.ramdan.cdt.cdm.service;

import agus.ramdan.cdt.cdm.domain.ServiceTransaction;
import agus.ramdan.cdt.cdm.dto.qrcode.QRCodeCDMResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "coreClient", url = "${feign-client.api-core-service.base-url}")
public interface CoreClient {

    @GetMapping("api/bpms/machine/qr_code/validate/{token}")
    QRCodeCDMResponse validateCode(@PathVariable(value = "token") String token) ;

    @GetMapping("api/bpms/machine/qr_code/validate/{token}")
    ServiceTransaction getServiceTransaction(@PathVariable(value = "token") String token);
}
