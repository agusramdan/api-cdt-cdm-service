package agus.ramdan.base.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
@Getter
@Schema(description = "Errors")
public class Errors {
    private final Date timestamp;
    private final String message;
    private final String trace_id;
    private final String span_id;
    private final String details;
    private final ErrorValidation[] errors;
}