package agus.ramdan.cdt.cdm.utils;


import agus.ramdan.cdt.core.trx.controller.client.QRCodeQueryClient;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ValidTokenQRValidator implements ConstraintValidator<ValidTokenQR, String> {

    private final QRCodeQueryClient client;

    @Override
    public boolean isValid(String token, ConstraintValidatorContext context) {
        if (token == null || token.isEmpty()) {
            return false;
        }
        // todo: gunakan validateCode
        try {
            val response = client.getByCodeDTO(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
