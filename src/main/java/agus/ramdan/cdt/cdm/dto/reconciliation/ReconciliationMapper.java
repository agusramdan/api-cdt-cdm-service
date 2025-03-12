package agus.ramdan.cdt.cdm.dto.reconciliation;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ReconciliationMapper {
    ReconciliationDto toReconciliationDto(ReconciliationRequest request);
}
