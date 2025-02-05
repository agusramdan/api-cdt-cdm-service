package com.agus.ramdan.cdm.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Schema
public class TrxCashDepositMachine {
    private Long id;
    private LocalDateTime created_on;
    private LocalDateTime updated_on;
    public String updated_by;
    private String qr_code;
    private String username;
    private String user_type;
    private String crew_code;
    private String crew_type;
    private String partner_code;
    private String partner_type;
    private String machine_deposit_code;
    private String machine_deposit_sn;
    private String service_product_code;
    private String service_product_name;
    private String partner_trx_no;
    private String internal_trx_number;
    private LocalDateTime trx_date;
    private BigDecimal amount;
    private List<TrxDepositMachineDenomination> denominations = new ArrayList<>();
}