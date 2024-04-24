package mx.edu.itoaxaca.api.v1.workshop.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.itoaxaca.api.v1.career.domain.Career;

@Data
@Entity
@Table(name = "workshops")
@NoArgsConstructor
public class Workshop {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    @Convert(converter = WorkshopNameConverter.class)
    private WorkshopName name;

    @Column(name = "date")
    @Convert(converter = WorkshopDateConverter.class)
    private WorkshopDate date;

    @Column(name = "speaker")
    @Convert(converter = WorkshopSpeakerConverter.class)
    private WorkshopSpeaker speaker;

    @Column(name = "speaker_institution")
    @Convert(converter = WorkshopSpeakerInstitutionConverter.class)
    private WorkshopSpeakerInstitution speakerInstitution;

    @ManyToMany
    @JoinTable(
        name = "career_workshops",
        joinColumns = { @JoinColumn(name = "workshop_id") },
        inverseJoinColumns = { @JoinColumn(name = "career_id") }
    )
    private List<Career> careers;

    public Workshop(
        UUID id,
        WorkshopName name,
        WorkshopDate date,
        WorkshopSpeaker speaker,
        WorkshopSpeakerInstitution speakerInstitution
    ) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.speaker = speaker;
        this.speakerInstitution = speakerInstitution;
    }

    public Workshop(UUID id, WorkshopName name, WorkshopDate date, WorkshopSpeaker speaker,
            WorkshopSpeakerInstitution speakerInstitution, List<Career> careers) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.speaker = speaker;
        this.speakerInstitution = speakerInstitution;
        this.careers = careers;
    }



}
