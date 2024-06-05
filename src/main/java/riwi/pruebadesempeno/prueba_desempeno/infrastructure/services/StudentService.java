package riwi.pruebadesempeno.prueba_desempeno.infrastructure.services;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import riwi.pruebadesempeno.prueba_desempeno.api.dto.request.StudentRequest;
import riwi.pruebadesempeno.prueba_desempeno.api.dto.response.ClassBasicResponse;
import riwi.pruebadesempeno.prueba_desempeno.api.dto.response.StudentBasicResponse;
import riwi.pruebadesempeno.prueba_desempeno.api.dto.response.StudentResponse;
import riwi.pruebadesempeno.prueba_desempeno.domain.entities.ClassEntity;
import riwi.pruebadesempeno.prueba_desempeno.domain.entities.StudentEntity;
import riwi.pruebadesempeno.prueba_desempeno.domain.repositories.ClassRepository;
import riwi.pruebadesempeno.prueba_desempeno.domain.repositories.StudentRepository;
import riwi.pruebadesempeno.prueba_desempeno.infrastructure.abtracs_service.IStudentService;
import riwi.pruebadesempeno.prueba_desempeno.utils.exceptions.BadRequestException;

@Service
@AllArgsConstructor
public class StudentService implements IStudentService {

    @Autowired
    private final StudentRepository studentRepository;
    private final ClassRepository classRepository;
    @Override
    public StudentResponse create(StudentRequest request) {
        StudentEntity entity = this.requestToEntity(request);
        entity.setActive(true);
        entity.setCreated_at(LocalDateTime.now());

        entity.setClassentity(this.classRepository.findById(request.getClasses()).orElseThrow(() -> new BadRequestException("No se encontro el id")));
        return this.entitytoResponse(this.studentRepository.save(entity));
    }

    @Override
    public void delete(Long id) {
        this.studentRepository.delete(this.find(id));
        
    }

    @Override
    public StudentResponse get(Long id) {
       return this.entitytoResponse(this.find(id));
        
    }

    public StudentBasicResponse getid(Long id){
        return this.entityBasicResponse(this.find(id));

    }
    @Override
    public Page<StudentResponse> getAll(int page, int size, String name) {
        if (page < 0)
            page = 0;
        PageRequest pagination = PageRequest.of(page, size);
        
        return this.studentRepository.findByNameOrActive(name, true, pagination).map(this::entitytoResponse);
    }
    @Override
    public StudentResponse update(StudentRequest request, Long id) {
        StudentEntity entity = this.find(id);
        entity.setName(request.getName());
        entity.setEmail(request.getEmail());
        entity.setActive(request.getActive());
        entity.setId(id);
        return this.entitytoResponse(this.studentRepository.save(entity));
    }



    //metodos propios
 
    private StudentResponse entitytoResponse(StudentEntity entity) {
   
        return StudentResponse.builder()
               .id(entity.getId())
               .name(entity.getName())
               .email(entity.getEmail())
               .active(entity.getActive())
               .created_at(entity.getCreated_at())
               .build();
    }
    private StudentBasicResponse entityBasicResponse(StudentEntity entity) {
            ClassBasicResponse classBasic = new ClassBasicResponse();
            BeanUtils.copyProperties(entity.getClassentity(), classBasic);


        return StudentBasicResponse.builder()
               .id(entity.getId())
               .name(entity.getName())
               .email(entity.getEmail())
               .active(entity.getActive())
               .created_at(entity.getCreated_at())
               .classResponse(classBasic)
               .build();


    }
    private StudentEntity requestToEntity(StudentRequest request) {
        return StudentEntity.builder()
               .name(request.getName())
               .email(request.getEmail())
               .build();
    }
        private StudentEntity find(Long id) {

        return this.studentRepository.findById(id).orElseThrow(() -> new BadRequestException("No se encontro el id"));
    }
    
      
}
