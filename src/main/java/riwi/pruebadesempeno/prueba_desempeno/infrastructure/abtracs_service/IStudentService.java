package riwi.pruebadesempeno.prueba_desempeno.infrastructure.abtracs_service;

import riwi.pruebadesempeno.prueba_desempeno.api.dto.request.StudentRequest;
import riwi.pruebadesempeno.prueba_desempeno.api.dto.response.StudentResponse;
import riwi.pruebadesempeno.prueba_desempeno.domain.repositories.StudentRepository;

public interface IStudentService extends CrudServiceUnic<StudentRequest,StudentResponse,Long>{

    Object getid(Long id);

}
