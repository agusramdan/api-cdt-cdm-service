package agus.ramdan.cdt.cdm.controller;


import agus.ramdan.base.exception.BadRequestException;
import agus.ramdan.base.exception.ResourceNotFoundException;
import agus.ramdan.cdt.cdm.domain.TrxCashDepositMachine;
import agus.ramdan.cdt.cdm.dto.TrxDepositMachineDto;
import agus.ramdan.cdt.cdm.dto.TrxDepositMachineMapper;
import agus.ramdan.cdt.cdm.dto.TrxDepositMachineRequest;
import agus.ramdan.cdt.cdm.dto.TrxDepositMachineResponse;
import agus.ramdan.cdt.cdm.service.QRCodeService;
import agus.ramdan.cdt.core.trx.controller.client.CdtCoreTrxClient;
import agus.ramdan.cdt.core.trx.controller.client.QRCodeQueryClient;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
@RequestMapping("/api/cdm/transaction")
@RequiredArgsConstructor
@Validated
public class DepositTrxController {

    //private final TrxDepositMachineRepository repository;
    private final QRCodeQueryClient coreClient;
    private final CdtCoreTrxClient cdmCoreClient;
    private final TrxDepositMachineMapper mapper;
    private final QRCodeService qrCodeService;

//    @GetMapping("")
//    @Operation(summary = "Get All")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "successful operation",
//                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = TrxDepositMachine.class)))),
//            @ApiResponse(responseCode = "204", description = "Data not found", content = @Content),
//            @ApiResponse(responseCode = "400", description = "Invalid tag value", content = @Content) })
//    public ResponseEntity<List<TrxDepositMachineDto>> getAll(
//            @RequestParam(value = "offset", required = false, defaultValue = "0") int offset,
//            @RequestParam(value = "limit", required = false, defaultValue = "25") int limit,
//            @RequestParam(value = "search", required = false) String search,
//            @RequestParam(value = "ids", required = false) String ids
//    ) {
//        val builder = new BaseSpecificationsBuilder<TrxDepositMachine>();
//        if (StringUtils.hasText(ids)){
//            val list = Arrays.stream(ids.split(","))
//                    .map(String::trim) // Menghapus spasi di sekitar angka
//                    .map(Long::parseLong) // Mengonversi ke Long
//                    .collect(Collectors.toList());
//            builder.ids_in(list);
//            if (!list.isEmpty()){
//                limit = Math.max(list.size(),limit);
//            }
//        }
//        builder.withSearch(search);
//        val spec = builder.build(BaseSpecifications::new);
//        val pageable = new OffsetBasedPageRequest(offset,limit);
//        val page = repository.findAll(spec,pageable);
//        ChekUtils.ifEmptyThrow(page);
//        val content = page.getContent().stream()
//                .map(mapper::trxDepositMachineToTrxDepositMachineDto)
//                .collect(Collectors.toList());
//        return new ResponseEntity<>(content, HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    @Operation(summary = "Get By Id")
//    @ApiResponses(value = {
//            @ApiResponse(description = "successful operation",content = {
//                    @Content(mediaType = "application/json", schema = @Schema(implementation = TrxDepositMachineResponse.class)), })
//    })
//    public ResponseEntity<TrxDepositMachineResponse> getById(@PathVariable("id") long id)
//            throws ResourceNotFoundException {
//        var data = ChekUtils.getOrThrow(repository.findById(id),()-> "Data not found for this id :: " + id);
//        val response = mapper.trxDepositMachineToTrxDepositMachineResponse(data);
//        return ResponseEntity.ok().body(response);
//    }

    @PostMapping("/deposit")
    @Operation(summary = "Deposit Transaction")
    @ApiResponses(value = {
            @ApiResponse(description = "successful operation",content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = TrxDepositMachineDto.class)), })
    })
    public ResponseEntity<TrxDepositMachineResponse> postCreate(@RequestBody @Valid TrxDepositMachineRequest request) throws BadRequestException, ResourceNotFoundException {

        TrxCashDepositMachine trx_request = mapper.toTrxDepositMachine(request);

//        ServiceTransaction serviceTransaction = qrCodeService.createServiceTransaction(
//                ServiceTransaction.builder()
//                        .token(request.getQr_code())
//                        .signature(request.getSignature())
//                        .build()
//        );
//        trx_request.setService_transaction_id(serviceTransaction.getService_transaction_id());
//        trx_request.setService_transaction_no(serviceTransaction.getService_transaction_no());
//        trx_request.setService_product_id(serviceTransaction.getService_product_id());
//        trx_request.setService_product_code(serviceTransaction.getService_product_code());
//        trx_request.setService_product_name(serviceTransaction.getService_product_name());
//        // mapping
//        TrxCashDepositMachine trx_result =cdmCoreClient.deposit(trx_request);
//        qrCodeService.usedCode(request.getQr_code());
//
//        TrxDepositMachineResponse response = mapper.toTrxDepositMachineResponse(trx_result);
        return ResponseEntity.status(HttpStatus.CREATED).body(TrxDepositMachineResponse.builder().build());
    }

    @PostMapping("/reversal")
    @Operation(summary = "Reversal Deposit Transaction")
    @ApiResponses(value = {
            @ApiResponse(description = "successful operation",content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = TrxDepositMachineDto.class)), })
    })
    public ResponseEntity<TrxDepositMachineResponse> reversal(@RequestBody @Valid TrxDepositMachineRequest request) throws BadRequestException, ResourceNotFoundException {

        //        val errors = new ArrayList<ErrorValidation>();
//        val qr_code = qrCodeService.validateCode(request.getQr_code());
//        val option_trx = repository.findByQr_code(qr_code.getCode());
//        if (option_trx.isPresent()){
//            errors.add(new ErrorValidation("Deposit Transaction Duplicate QR Code","qr_code",qr_code.getCode()));
//        }
//        val new_data = mapper.trxDepositMachineRequestToTrxDepositMachine(request);
        //TODO Validate relation and constrain
//        if(!errors.isEmpty()){
//            throw new BadRequestException("Validation Error",errors.toArray(new ErrorValidation[0]));
//        }
//        val data = repository.save(new_data);
//        qrCodeService.usedCode(qr_code.getCode());
        TrxCashDepositMachine trx_result =cdmCoreClient.deposit(mapper.toTrxDepositMachine(request));
        TrxDepositMachineResponse response = mapper.toTrxDepositMachineResponse(trx_result);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @PostMapping("/get_trx")
    @Operation(summary = "Get Transaction")
    @ApiResponses(value = {
            @ApiResponse(description = "successful operation",content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = TrxDepositMachineDto.class)), })
    })
    public ResponseEntity<TrxDepositMachineResponse> getCreate(@RequestBody @Valid TrxDepositMachineRequest request) throws BadRequestException, ResourceNotFoundException {
//        val errors = new ArrayList<ErrorValidation>();
//        val qr_code = qrCodeService.validateCode(request.getQr_code());
//        val option_trx = repository.findByQr_code(qr_code.getCode());
//        if (option_trx.isPresent()){
//            errors.add(new ErrorValidation("Deposit Transaction Duplicate QR Code","qr_code",qr_code.getCode()));
//        }
//        val new_data = mapper.trxDepositMachineRequestToTrxDepositMachine(request);
        //TODO Validate relation and constrain
//        if(!errors.isEmpty()){
//            throw new BadRequestException("Validation Error",errors.toArray(new ErrorValidation[0]));
//        }
//        val data = repository.save(new_data);
//        qrCodeService.usedCode(qr_code.getCode());
        TrxCashDepositMachine dto =cdmCoreClient.deposit(mapper.toTrxDepositMachine(request));
        TrxDepositMachineResponse response = mapper.toTrxDepositMachineResponse(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
