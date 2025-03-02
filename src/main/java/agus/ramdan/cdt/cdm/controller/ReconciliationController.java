package agus.ramdan.cdt.cdm.controller;


import agus.ramdan.base.exception.BadRequestException;
import agus.ramdan.base.exception.ResourceNotFoundException;
import agus.ramdan.cdt.cdm.dto.reconciliation.ReconciliationDto;
import agus.ramdan.cdt.cdm.dto.reconciliation.ReconciliationMapper;
import agus.ramdan.cdt.cdm.dto.reconciliation.ReconciliationRequest;
import agus.ramdan.cdt.cdm.dto.deposit.TrxDepositMachineMapper;
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
@RequestMapping({"/api/cdt/cdm/reconciliation"})
@RequiredArgsConstructor
@Validated
public class ReconciliationController {

    //private final DepositMachineStatusRepository repository;
      private ReconciliationMapper mapper;
//    @GetMapping("")
//    @Operation(summary = "Get All")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "successful operation",
//                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = DepositMachineStatus.class)))),
//            @ApiResponse(responseCode = "204", description = "Data not found", content = @Content),
//            @ApiResponse(responseCode = "400", description = "Invalid tag value", content = @Content) })
//    public ResponseEntity<List<DepositMachineStatus>> getAll(
//            @RequestParam(value = "offset", required = false, defaultValue = "0") int offset,
//            @RequestParam(value = "limit", required = false, defaultValue = "25") int limit,
//            @RequestParam(value = "search", required = false) String search,
//            @RequestParam(value = "ids", required = false) String ids
//    ) {
//        val builder = new BaseSpecificationsBuilder<DepositMachineStatus>();
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
//        val page =  new PageImpl<DepositMachineStatus>(List.of());//repository.findAll(spec,pageable);
//        ChekUtils.ifEmptyThrow(page);
//        return new ResponseEntity<>(page.getContent(), HttpStatus.OK);
//    }

//    @GetMapping("/{id}")
//    @Operation(summary = "Get By Id ")
//    @ApiResponses(value = {
//            @ApiResponse(description = "successful operation",content = {
//                    @Content(mediaType = "application/json", schema = @Schema(implementation = CashDepositMachineStatus.class)), })
//    })
//    public ResponseEntity<ReconciliationDto> getById(@PathVariable("id") String id)
//            throws ResourceNotFoundException {
////        var data = ChekUtils.getOrThrow(repository.findById(id),()-> "Data not found for this id :: " + id);
////        return ResponseEntity.ok().body(data);
//        return ResponseEntity.ok().build();
//    }

    @PostMapping
    @Operation(summary = "Machine Deposit Capacity")
    @ApiResponses(value = {
            @ApiResponse(description = "successful operation",content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ReconciliationRequest.class)), })
    })
    public ResponseEntity<ReconciliationDto> postCreate(@RequestBody @Valid ReconciliationRequest request) throws BadRequestException, ResourceNotFoundException {
        //val response = repository.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toReconciliationDto(request));
    }

}
