package agus.ramdan.cdt.core.trx.controller.client;

import agus.ramdan.cdt.core.trx.controller.dto.qrcode.QRCodeQueryDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cdtCoreTrxQRCodeClient", url = "${feign-client.core-trx.base-url}/api/cdt/core/trx/qr_code")
public interface QRCodeClient {

    @GetMapping("/query/code/{code}")
    QRCodeQueryDTO getByCode(@PathVariable String code);

}
