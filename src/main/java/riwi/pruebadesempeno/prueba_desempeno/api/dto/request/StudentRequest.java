package riwi.pruebadesempeno.prueba_desempeno.api.dto.request;

import jakarta.validation.constraints.Email;
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
public class StudentRequest {
     @NotBlank(message = "name requerido")
     private String name;
     @Email(message = "email requerido")
     private String email;
     @NotNull(message = "Id requerido")
     private Long classes;
        
}
