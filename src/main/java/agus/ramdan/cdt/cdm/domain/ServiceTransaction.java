package agus.ramdan.cdt.cdm.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Schema
@Builder
public class ServiceTransaction {

    private String token;
    private String signature;
    private String status;

    private String service_transaction_id;
    private String service_transaction_no;

    private String service_product_id;
    private String service_product_code;
    private String service_product_name;
}