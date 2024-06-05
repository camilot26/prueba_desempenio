package riwi.pruebadesempeno.prueba_desempeno.api.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import riwi.pruebadesempeno.prueba_desempeno.utils.enums.TypeEnum;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class MultimediaResponse {
    private Long id;
    private TypeEnum type;
    private String url;
    private LocalDateTime created_at;
    private LessonResponse lesson;
    private Boolean active;
}
