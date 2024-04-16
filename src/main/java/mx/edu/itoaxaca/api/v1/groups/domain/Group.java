package mx.edu.itoaxaca.api.v1.groups.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "groups")
@AllArgsConstructor
@NoArgsConstructor
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    @Convert(converter = GroupNameConverter.class)
    private GroupName name;

    @Column(name = "code", nullable = false)
    @Convert(converter = GroupCodeConverter.class)
    private GroupCode code;

    @Column(name = "created_at", nullable = false)
    @Convert(converter = GroupCreatedAtConverter.class)
    @CreatedDate
    private GroupCreatedAt createdAt;
}
