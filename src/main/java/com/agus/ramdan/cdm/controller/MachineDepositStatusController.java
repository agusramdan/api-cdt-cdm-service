package com.agus.ramdan.cdm.controller;


import com.agus.ramdan.cdm.exception.BadRequestException;
import com.agus.ramdan.cdm.exception.ResourceNotFoundException;
import com.agus.ramdan.cdm.domain.CashDepositMachineStatus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 *
 */
@RestController
@RequestMapping("/api/cdm/status")
@RequiredArgsConstructor
@Validated
public class MachineDepositStatusController {

    //private final DepositMachineStatusRepository repository;

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

    @GetMapping("/{id}")
    @Operation(summary = "Get By Id ")
    @ApiResponses(value = {
            @ApiResponse(description = "successful operation",content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CashDepositMachineStatus.class)), })
    })
    public ResponseEntity<CashDepositMachineStatus> getById(@PathVariable("id") long id)
            throws ResourceNotFoundException {
//        var data = ChekUtils.getOrThrow(repository.findById(id),()-> "Data not found for this id :: " + id);
//        return ResponseEntity.ok().body(data);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    @Operation(summary = "Machine Deposit Capacity")
    @ApiResponses(value = {
            @ApiResponse(description = "successful operation",content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CashDepositMachineStatus.class)), })
    })
    public ResponseEntity<CashDepositMachineStatus> postCreate(@RequestBody @Valid CashDepositMachineStatus request) throws BadRequestException, ResourceNotFoundException {
        //val response = repository.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }
//    @PostMapping("/un_available")
//    @Operation(summary = "Un Available")
//    @ApiResponses(value = {
//            @ApiResponse(description = "Un Available chek pint")
//    })
//    public ResponseEntity<Map<String,Object>> status_un_available(
//            @Min(value = 1, message = "Min 1 hours")
//            @Max(value = 10, message = "Max 10 hours")
//            @RequestParam(value = "expired", required = false, defaultValue = "2") int limit
//    ) {
//        val response = new HashMap<String,Object>();
//        LocalDateTime expired = LocalDateTime.now().minusHours(limit);
//        response.put("expired", expired);
//        response.put("count", repository.updateStatusUnAvailable(expired));
//        return ResponseEntity.ok().body(response);
//    }
}
