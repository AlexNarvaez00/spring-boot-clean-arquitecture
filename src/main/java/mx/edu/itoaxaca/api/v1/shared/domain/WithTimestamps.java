package mx.edu.itoaxaca.api.v1.shared.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class WithTimestamps {

    @CreatedDate
    @Column(name = "created_at", nullable = true)
    @Convert(converter = CreatedAtConverter.class)
    private CreatedAt createdAt;

    @Column(name = "update_at", nullable = true)
    @Convert(converter = UpdatedAtConverter.class)
    private UpdatedAt updateAt;

    @Column(name = "deleted_at", nullable = true)
    @Convert(converter = DeletedAtConverter.class)
    private DeletedAt deletedAt;

    public WithTimestamps() {
        this.createdAt = new CreatedAt(LocalDateTime.now());
    }
}
