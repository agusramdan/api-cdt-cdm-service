package agus.ramdan.cdt.cdm.utils;


import agus.ramdan.base.exception.BadRequestException;
import agus.ramdan.base.exception.NoContentException;
import agus.ramdan.base.exception.ResourceNotFoundException;
import agus.ramdan.cdt.cdm.service.CoreClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class ValidTokenQRValidator implements ConstraintValidator<ValidTokenQR, String> {

    private final CoreClient client;

    @Override
    public boolean isValid(String token, ConstraintValidatorContext context) {
        if (token == null || token.isEmpty()) {
            return false;
        }
        try {
            client.validateCode(token);
            return true; // Panggil service untuk validasi
        }catch (ResourceNotFoundException | BadRequestException | NoContentException e){
            return false;
        }
    }
}
