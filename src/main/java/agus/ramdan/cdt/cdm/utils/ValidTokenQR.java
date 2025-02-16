package agus.ramdan.cdt.cdm.utils;

//import jakarta.validation.Constraint;
//import jakarta.validation.Payload;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidTokenQRValidator.class) // Menghubungkan dengan validator
public @interface  ValidTokenQR {
    String message() default "Invalid QR";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
