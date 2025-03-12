package agus.ramdan.cdt.cdm.controller.command;

import agus.ramdan.base.exception.BadRequestException;
import agus.ramdan.base.exception.ResourceNotFoundException;
import agus.ramdan.cdt.cdm.dto.deposit.TrxDepositCommandDTO;
import agus.ramdan.cdt.cdm.dto.deposit.TrxDepositDTO;
import agus.ramdan.cdt.cdm.dto.deposit.TrxDepositMapper;
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
@RequestMapping({"/api/cdm/transaction/deposit", "/api/cdt/cdm/command/deposit"})
@RequiredArgsConstructor
@Validated
@Log4j2
public class CmdDepositCommandController {
    private final TrxDepositCommandClient client;
    private final TrxDepositMapper mapper;
    @PostMapping("")
    @Operation(summary = "Deposit")
    @ApiResponses(value = {
            @ApiResponse(description = "successful operation", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = TrxDepositDTO.class)),})
    })
    public ResponseEntity<TrxDepositDTO> postCreate(@RequestBody @Valid TrxDepositCommandDTO request) throws BadRequestException, ResourceNotFoundException {
        val dto = mapper.toTrxDepositCreateDTO(request);
        val result = client.create(dto);
        val response = mapper.toTrxDepositDTO(result);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
