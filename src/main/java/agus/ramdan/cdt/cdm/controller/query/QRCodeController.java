package agus.ramdan.cdt.cdm.controller.query;

import agus.ramdan.base.exception.BadRequestException;
import agus.ramdan.cdt.cdm.dto.qrcode.QRCodeCDMResponse;
import agus.ramdan.cdt.cdm.dto.qrcode.QRCodeMapper;
import agus.ramdan.cdt.core.trx.controller.client.QRCodeQueryClient;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("api-cdt-cdm-qr-code-controller")
@RequestMapping({"/api/cdt/cdm/qr_code"})
@RequiredArgsConstructor
public class QRCodeController {
    private final QRCodeMapper mapper;
    private final QRCodeQueryClient client;

    @GetMapping("validate/{code}")
    @Operation(summary = "Validate QR Code (api_validate_qr_code)")
    @ApiResponses(value = {
            @ApiResponse(description = "successful operation",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = QRCodeCDMResponse.class)),
                    })
    })
    public ResponseEntity<QRCodeCDMResponse> validateCode(@PathVariable("code") String code) {
        val queryDTO = client.getByCodeDTO(code);
        if (queryDTO.getActive()) {
            val response = mapper.fromQRCodeQueryDTO(queryDTO);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            throw new BadRequestException("Code Not Active");
        }

    }
}
