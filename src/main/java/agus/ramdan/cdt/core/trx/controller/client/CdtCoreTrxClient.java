package agus.ramdan.cdt.core.trx.controller.client;

import agus.ramdan.base.exception.ResourceNotFoundException;
import agus.ramdan.cdt.cdm.domain.TrxCashDepositMachine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "cdtCoreTrxClient", url = "${feign-client.api-cdm-core-service.base-url}")
public interface CdtCoreTrxClient {

    @PostMapping("api/cdm/core/deposit/get_trx")
    TrxCashDepositMachine get_trx(@RequestBody TrxCashDepositMachine request) throws ResourceNotFoundException;

    @PostMapping("api/cdm/core/deposit")
    TrxCashDepositMachine deposit(@RequestBody TrxCashDepositMachine request) ;

}
