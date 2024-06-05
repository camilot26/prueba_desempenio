package riwi.pruebadesempeno.prueba_desempeno.domain.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import riwi.pruebadesempeno.prueba_desempeno.utils.enums.TypeEnum;

@Entity(name = "multimedia")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MultimediaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeEnum type;
    @Column( columnDefinition = "TEXT"   )
    private String url;
    private LocalDateTime created_at;
    private Boolean active;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="lesson_id", referencedColumnName="id")
    private LessonEntity lessonEntity;
}
