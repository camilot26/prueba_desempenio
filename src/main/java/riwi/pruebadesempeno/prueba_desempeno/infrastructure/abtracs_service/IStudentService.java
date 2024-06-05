package riwi.pruebadesempeno.prueba_desempeno.infrastructure.abtracs_service;

import riwi.pruebadesempeno.prueba_desempeno.api.dto.request.StudentRequest;
import riwi.pruebadesempeno.prueba_desempeno.domain.repositories.StudentRepository;

public interface IStudentService extends CrudService<StudentRequest,StudentRepository,Long>{

}
