package agus.ramdan.cdt.cdm.controller.query;

import agus.ramdan.base.exception.BadRequestException;
import agus.ramdan.base.exception.ResourceNotFoundException;
import agus.ramdan.cdt.cdm.dto.deposit.TrxDepositMachineDto;
import agus.ramdan.cdt.cdm.dto.deposit.TrxDepositMachineMapper;
import agus.ramdan.cdt.cdm.dto.deposit.TrxDepositMachineRequest;
import agus.ramdan.cdt.cdm.dto.deposit.TrxDepositMachineResponse;
import agus.ramdan.cdt.core.trx.controller.client.TrxDepositCommandClient;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/cdm/transaction/get_trx", "/api/cdt/cdm/query/deposit"})
@RequiredArgsConstructor
@Validated
@Log4j2
public class CmdDepositQueryController {

    private final TrxDepositCommandClient client;
    private final TrxDepositMachineMapper mapper;

    @PostMapping("")
    @Operation(summary = "Get Deposit")
    @ApiResponses(value = {
            @ApiResponse(description = "successful operation", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = TrxDepositMachineDto.class)),})
    })
    public ResponseEntity<TrxDepositMachineResponse> getCreate(@RequestBody @Valid TrxDepositMachineRequest request) throws BadRequestException, ResourceNotFoundException {
        val dto = client.create(mapper.toTrxDepositCreateDTO(request));
        TrxDepositMachineResponse response = mapper.toTrxDepositMachineResponse(dto);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
