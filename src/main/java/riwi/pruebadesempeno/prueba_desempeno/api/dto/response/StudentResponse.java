package riwi.pruebadesempeno.prueba_desempeno.api.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {
    private Long id;
    private String name;
    private String email;
    private Boolean active;
    private LocalDateTime created_at;
    private List<ClassResponse> classes;
    


}
