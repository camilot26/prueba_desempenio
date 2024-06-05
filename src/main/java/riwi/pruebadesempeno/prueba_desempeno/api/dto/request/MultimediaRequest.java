package riwi.pruebadesempeno.prueba_desempeno.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import riwi.pruebadesempeno.prueba_desempeno.utils.enums.TypeEnum;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class MultimediaRequest {
    @NotBlank(message = "type requerido")
    private TypeEnum typeEnum;
    @NotBlank(message = "url requerido")
    private String url;
    @NotNull(message="id requerido")
    private Long lesson_id;
}
