package riwi.pruebadesempeno.prueba_desempeno.infrastructure.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import riwi.pruebadesempeno.prueba_desempeno.api.dto.request.StudentRequest;
import riwi.pruebadesempeno.prueba_desempeno.api.dto.response.StudentResponse;
import riwi.pruebadesempeno.prueba_desempeno.domain.entities.StudentEntity;
import riwi.pruebadesempeno.prueba_desempeno.domain.repositories.StudentRepository;
import riwi.pruebadesempeno.prueba_desempeno.infrastructure.abtracs_service.IStudentService;

@Service
@AllArgsConstructor
public class StudentService implements IStudentService {


    private final StudentRepository studentRepository;
    @Override
    public StudentRepository create(StudentRequest request) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public StudentRepository get(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<StudentRepository> getAll(int page, int size,String name, String description) {
        if (page < 0)
            page = 0;
        PageRequest pagination = PageRequest.of(page, size);
        
        return ;
    }

    @Override
    public StudentRepository update(StudentRequest request, Long id) {
        // TODO Auto-generated method stub
        return null;
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
}
