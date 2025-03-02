package agus.ramdan.cdt.cdm.dto.deposit;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrxDepositMachineDenominationRequest implements Serializable {
    @NotNull(message = "type cannot be null.")
    @NotEmpty(message = "type cannot be empty.")
    @Pattern(regexp = "coin|note", message = "Invalid type. Only 'coin' or 'note' are allowed.")
    private String type;
    @NotNull(message = "denomination cannot be null.")
    @Positive(message = "denomination must be positive value.")
    @Digits(integer = 10, fraction = 2, message = "Invalid denomination format. Expected: #0.00")
    private String denomination;
    @NotNull(message = "quantity cannot be null.")
    @Positive(message = "quantity must be positive value.")
    private Integer quantity;
    @Positive(message = "amount cannot be negative or zero value.")
    @NotNull(message = "amount must be positive value.")
    @Digits(integer = 10, fraction = 2, message = "Invalid amount format. Expected: #0.00")
    private String amount;
}
