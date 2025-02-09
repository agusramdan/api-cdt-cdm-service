package com.agus.ramdan.cdm.service;

import com.agus.ramdan.cdm.dto.QRCodeResponse;
import com.agus.ramdan.cdm.dto.TrxDepositMachineDto;
import com.agus.ramdan.cdm.dto.TrxDepositMachineRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name = "coreClient", url = "${feign-client.api-core-service.base-url}")
public interface CoreClient {

    @GetMapping("api/bpms/machine/qr_code/validate/{token}")
    QRCodeResponse validateCode(@PathVariable(value = "token") String token) ;

    @GetMapping("api/bpms/machine/qr_code/validate/{token}")
    QRCodeResponse validateCode(@PathVariable(value = "token") String token, @RequestHeader Map<String, String> headers) ;

    @PostMapping("api/bpms/machine/deposit/transaction")
    TrxDepositMachineDto depositTransaction(@RequestBody TrxDepositMachineRequest request) ;

}
