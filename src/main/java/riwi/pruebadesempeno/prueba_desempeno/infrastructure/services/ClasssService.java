package riwi.pruebadesempeno.prueba_desempeno.infrastructure.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import riwi.pruebadesempeno.prueba_desempeno.api.dto.request.ClassRequest;
import riwi.pruebadesempeno.prueba_desempeno.api.dto.response.ClassResponse;
import riwi.pruebadesempeno.prueba_desempeno.domain.entities.ClassEntity;
import riwi.pruebadesempeno.prueba_desempeno.domain.repositories.ClassRepository;
import riwi.pruebadesempeno.prueba_desempeno.infrastructure.abtracs_service.IClassService;
import riwi.pruebadesempeno.prueba_desempeno.utils.exceptions.BadRequestException;

@Service
@AllArgsConstructor
public class ClasssService implements IClassService {

    @Autowired
    private final ClassRepository classRepository;

    @Override
    public ClassResponse create(ClassRequest request) {
        ClassEntity entity = this.requestToEntity(request);
        entity.setActive(true);
        entity.setCreated_at(LocalDateTime.now());

        return this.entityToResponse(this.classRepository.save(entity));
    }

    @Override
    public void delete(Long id) {
        this.classRepository.delete(this.find(id));

    }

    @Override
    public ClassResponse get(Long id) {
        return this.entityToResponse(this.find(id));
    }



    @Override
    public ClassResponse update(ClassRequest request, Long id) {
        ClassEntity entity = this.find(id);
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setActive(request.getActive());
        return this.entityToResponse(this.classRepository.save(entity));
    }

    // metodos propios
    private ClassResponse entityToResponse(ClassEntity entity) {
        return ClassResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .active(entity.getActive())
                .created_at(entity.getCreated_at())
                .build();

    }

    private ClassEntity requestToEntity(ClassRequest request) {
        return ClassEntity.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build();

    }

    private ClassEntity find(Long id) {

        return this.classRepository.findById(id).orElseThrow(() -> new BadRequestException("No se encontro el id"));
    }

    @Override
    public Page<ClassResponse> getAll(int page, int size) {
        



        return null;
    }

   

}
