package mx.edu.itoaxaca.api.v1.action_plan.domain;

import jakarta.persistence.AttributeConverter;

public class ActionPlanCodeConverter 
    implements AttributeConverter<ActionPlanCode, String> {

    @Override
    public String convertToDatabaseColumn(ActionPlanCode attribute) {
        return (attribute == null) ? null : attribute.getValue();
    }

    @Override
    public ActionPlanCode convertToEntityAttribute(String dbData) {
        return (dbData == null) ? null : new ActionPlanCode(dbData);
    }
}
