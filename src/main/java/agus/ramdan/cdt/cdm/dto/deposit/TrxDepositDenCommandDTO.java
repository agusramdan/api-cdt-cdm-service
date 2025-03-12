package agus.ramdan.cdt.cdm.dto.deposit;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrxDepositDenCommandDTO implements Serializable {
    @NotNull(message = "denomination cannot be null.")
    @Positive(message = "denomination must be positive value.")
    @Digits(integer = 10, fraction = 2, message = "Invalid denomination format. Expected: #0.00")
    private BigDecimal denomination;
    @NotNull(message = "quantity cannot be null.")
    @Positive(message = "quantity must be positive value.")
    private Integer quantity;
    @Positive(message = "amount cannot be negative or zero value.")
    @NotNull(message = "amount must be positive value.")
    @Digits(integer = 10, fraction = 2, message = "Invalid amount format. Expected: #0.00")
    private BigDecimal amount;
}
