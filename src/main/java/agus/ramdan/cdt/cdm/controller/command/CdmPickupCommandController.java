package agus.ramdan.cdt.cdm.controller.command;


import agus.ramdan.base.exception.BadRequestException;
import agus.ramdan.base.exception.ResourceNotFoundException;
import agus.ramdan.cdt.cdm.dto.pickup.CdmPickupCreateDTO;
import agus.ramdan.cdt.cdm.dto.pickup.CdmPickupDTO;
import agus.ramdan.cdt.cdm.dto.pickup.CmdPickupMapper;
import agus.ramdan.cdt.core.trx.controller.client.TrxPickupCommandClient;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Pickup", description = "Pickup/Collection")
@RequestMapping("/api/cdt/cdm/command/pickup")
@RequiredArgsConstructor
@Validated
public class CdmPickupCommandController {

    private final TrxPickupCommandClient client;
    private final CmdPickupMapper mapper;

    @PostMapping()
    @Operation(summary = "Pickup/Collection")
    @ApiResponses(value = {
            @ApiResponse(description = "successful operation", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CdmPickupDTO.class)),})
    })
    public ResponseEntity<CdmPickupDTO> postCreate(@RequestBody @Valid CdmPickupCreateDTO request) throws BadRequestException, ResourceNotFoundException {
        val result = client.create(mapper.toTrxPickupCreateDTO(request));
        val response = mapper.toCdmPickupDTO(result);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
