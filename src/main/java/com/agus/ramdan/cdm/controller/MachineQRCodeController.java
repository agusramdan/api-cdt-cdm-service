package com.agus.ramdan.cdm.controller;

import com.agus.ramdan.cdm.dto.QRCodeResponse;
import com.agus.ramdan.cdm.exception.BadRequestException;
import com.agus.ramdan.cdm.exception.ResourceNotFoundException;
import com.agus.ramdan.cdm.service.QRCodeService;
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

/**
 *
 */
@RestController
@RequestMapping("/api/cdm/qr_code")
@RequiredArgsConstructor
public class MachineQRCodeController {

    public final QRCodeService service;

    @GetMapping("validate/{code}")
    @Operation(summary = "Validate QR Code (api_validate_qr_code)")
    @ApiResponses(value = {
            @ApiResponse(description = "successful operation",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = QRCodeResponse.class)),
                    })
    })

    public ResponseEntity<QRCodeResponse> validateCode(@PathVariable("code") String code) throws ResourceNotFoundException, BadRequestException {
        val response = service.validateCode(code);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
