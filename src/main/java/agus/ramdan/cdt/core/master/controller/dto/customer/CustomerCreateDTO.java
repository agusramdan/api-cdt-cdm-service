package agus.ramdan.cdt.core.master.controller.dto.customer;

import agus.ramdan.cdt.core.master.controller.dto.AddressDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Schema(name = "CustomerCreateDTO", description = "DTO for creating a customer")
public class CustomerCreateDTO {

    @NotBlank
    @Schema(description = "Customer Full Name", example = "John Doe")
    private String name;

    @JsonProperty("customer_type")
    @NotNull
    @Schema(description = "Customer Type (INDIVIDUAL or BUSINESS)", example = "INDIVIDUAL")
    private CustomerType customerType;

    @JsonProperty("ktp")
    private String ktp;

    @JsonProperty("npwp")
    private String npwp;

    @Email
    @Schema(description = "Customer Email Address", example = "john.doe@example.com")
    private String email;

    @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$", message = "Phone number must be in E.164 format")
    @Schema(description = "Customer Mobile Number", example = "+6281234567890")
    private String msidn;

    @Schema(description = "Customer Address Details")
    private AddressDTO address;
}
