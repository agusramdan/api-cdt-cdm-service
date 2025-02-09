package com.agus.ramdan.cdm.utils;


import com.agus.ramdan.cdm.exception.BadRequestException;
import com.agus.ramdan.cdm.exception.NoContentException;
import com.agus.ramdan.cdm.exception.ResourceNotFoundException;
import com.agus.ramdan.cdm.service.CoreClient;
//import jakarta.validation.ConstraintValidator;
//import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class ValidTokenQRValidator implements ConstraintValidator<ValidTokenQR, String> {

    private final CoreClient client;

    @Override
    public boolean isValid(String merchantId, ConstraintValidatorContext context) {
        if (merchantId == null || merchantId.isEmpty()) {
            return false; // Merchant ID tidak boleh kosong
        }
        try {
            client.validateCode(merchantId);
            return true; // Panggil service untuk validasi
        }catch (ResourceNotFoundException | BadRequestException | NoContentException e){
            return false;
        }
    }
}
