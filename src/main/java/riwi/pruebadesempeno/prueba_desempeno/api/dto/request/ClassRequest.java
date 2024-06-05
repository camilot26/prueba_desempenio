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
public class ClassRequest {
    @NotBlank(message="Nombre requerido")
    private String name;
    @NotBlank(message="Descripción requerida")
    private String description;
    private Boolean active;
   
}
