package riwi.pruebadesempeno.prueba_desempeno.api.dto.request.update;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClassUpdateRequest {
   @NotBlank(message="Nombre requerido")
    private String name;
    @NotBlank(message="Descripción requerida")
    private String description;
    private Boolean active;
    private LocalDateTime created_at;
}
