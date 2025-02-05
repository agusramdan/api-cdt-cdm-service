package com.agus.ramdan.cdm.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Schema
public class CashDepositMachineStatus {
    private Long id;
    private String code;
    private String serial_number;
    @Schema(description = "Status, 0 = Uknon, 1 = Offline , 2 = online,  ")
    private int status;
    @Schema(description = "percent capacity (max 100) ")
    private int percent;
    @Schema(description = "Jumlah Uang")
    private BigDecimal amount;
    private LocalDateTime last_pick_money;
    private LocalDateTime updated_on;
}