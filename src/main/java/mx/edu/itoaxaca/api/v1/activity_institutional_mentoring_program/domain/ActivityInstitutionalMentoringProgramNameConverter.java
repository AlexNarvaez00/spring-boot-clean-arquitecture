package mx.edu.itoaxaca.api.v1.activity_institutional_mentoring_program.domain;

import jakarta.persistence.AttributeConverter;

public class ActivityInstitutionalMentoringProgramNameConverter 
    implements AttributeConverter<ActivityInstitutionalMentoringProgramName, String> {

    @Override
    public String convertToDatabaseColumn(ActivityInstitutionalMentoringProgramName attribute) {
        return (attribute == null) ? null : attribute.getValue();
    }

    @Override
    public ActivityInstitutionalMentoringProgramName convertToEntityAttribute(String dbData) {
        return (dbData == null) ? null : new ActivityInstitutionalMentoringProgramName(dbData);
    }
}
