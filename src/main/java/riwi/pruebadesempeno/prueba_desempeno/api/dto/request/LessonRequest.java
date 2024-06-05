package riwi.pruebadesempeno.prueba_desempeno.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LessonRequest {
    @NotBlank(message="title requerido")
    private String title;
    @NotBlank(message="content requerido")
    private String content;
    @NotNull(message="class_id requerido")
    private Long class_id;
    

}
