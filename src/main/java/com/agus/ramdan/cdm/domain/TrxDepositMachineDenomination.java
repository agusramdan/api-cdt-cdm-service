package com.agus.ramdan.cdm.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

@Data
@Schema
public class TrxDepositMachineDenomination {
    private Long id;
    private BigDecimal denomination;
    private Integer quantity;
    private BigDecimal amount;
    private String type;

}