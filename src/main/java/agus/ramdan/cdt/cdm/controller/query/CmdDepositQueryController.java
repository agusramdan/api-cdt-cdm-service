package agus.ramdan.cdt.cdm.controller.query;

import agus.ramdan.base.exception.BadRequestException;
import agus.ramdan.base.exception.ResourceNotFoundException;
import agus.ramdan.cdt.cdm.dto.deposit.TrxDepositDTO;
import agus.ramdan.cdt.cdm.dto.deposit.TrxDepositMapper;
import agus.ramdan.cdt.core.trx.controller.client.TrxDepositQueryClient;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/cdt/cdm/query/deposit"})
@RequiredArgsConstructor
@Validated
@Log4j2
public class CmdDepositQueryController {

    private final TrxDepositQueryClient client;
    private final TrxDepositMapper mapper;

    @PostMapping("")
    @Operation(summary = "Get Deposit")
    @ApiResponses(value = {
            @ApiResponse(description = "successful operation", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = TrxDepositDTO.class)),})
    })
    public ResponseEntity<TrxDepositDTO> getBy(@RequestBody @Valid TrxDepositDTO request) throws BadRequestException, ResourceNotFoundException {
        // TODO
        //val response = mapper.toTrxDepositDTO(dto);
        return ResponseEntity.status(HttpStatus.OK).body(request);
    }
}
