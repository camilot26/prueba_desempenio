package riwi.pruebadesempeno.prueba_desempeno.infrastructure.abtracs_service;

import org.springframework.data.domain.Page;

import riwi.pruebadesempeno.prueba_desempeno.api.dto.request.ClassRequest;
import riwi.pruebadesempeno.prueba_desempeno.api.dto.response.ClassBasicResponse;
import riwi.pruebadesempeno.prueba_desempeno.api.dto.response.ClassResponse;

public interface IClassService extends CrudService <ClassRequest,ClassResponse,Long>{
Page<ClassBasicResponse> getAllin(String name, String description, Boolean active, int page, int size);

}
