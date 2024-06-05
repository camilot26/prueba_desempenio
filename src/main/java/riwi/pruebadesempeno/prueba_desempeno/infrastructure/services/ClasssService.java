package riwi.pruebadesempeno.prueba_desempeno.infrastructure.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import riwi.pruebadesempeno.prueba_desempeno.api.dto.request.ClassRequest;
import riwi.pruebadesempeno.prueba_desempeno.api.dto.response.ClassBasicResponse;
import riwi.pruebadesempeno.prueba_desempeno.api.dto.response.ClassResponse;
import riwi.pruebadesempeno.prueba_desempeno.api.dto.response.LessonResponse;
import riwi.pruebadesempeno.prueba_desempeno.api.dto.response.StudentResponse;
import riwi.pruebadesempeno.prueba_desempeno.domain.entities.ClassEntity;
import riwi.pruebadesempeno.prueba_desempeno.domain.entities.LessonEntity;
import riwi.pruebadesempeno.prueba_desempeno.domain.entities.StudentEntity;
import riwi.pruebadesempeno.prueba_desempeno.domain.repositories.ClassRepository;
import riwi.pruebadesempeno.prueba_desempeno.domain.repositories.StudentRepository;
import riwi.pruebadesempeno.prueba_desempeno.infrastructure.abtracs_service.IClassService;
import riwi.pruebadesempeno.prueba_desempeno.utils.exceptions.BadRequestException;

@Service
@AllArgsConstructor
public class ClasssService implements IClassService {

    @Autowired
    private final ClassRepository classRepository;
    private final StudentRepository studentRepository;
    @Override
    public ClassResponse create(ClassRequest request) {
        ClassEntity entity = this.requestToEntity(request);
        entity.setActive(true);
        entity.setCreated_at(LocalDateTime.now());
        entity.setStudents(new ArrayList<>());
        entity.setLessons(new ArrayList<>());
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
       return null;
    }

    // metodos propios
    private ClassResponse entityToResponse(ClassEntity entity) {
        List<StudentResponse> student = entity.getStudents()
            .stream()
            .map(this::entitytiStudentResponse)
            .collect(Collectors.toList());
        List<LessonResponse> lesson = entity.getLessons().stream().map(this::entityIsLessonResponse).collect(Collectors.toList());
        return ClassResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .active(entity.getActive())
                .created_at(entity.getCreated_at())
                .student(student)
                .lesson(lesson)
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

    private ClassBasicResponse entityBresponse(ClassEntity entity) {
        return ClassBasicResponse.builder()
                .id(entity.getId()).name(entity.getName()).description(entity.getDescription())
                .active(entity.getActive()).created_at(entity.getCreated_at()).build();

    }

    @Override
    public Page<ClassBasicResponse> getAllin(String name, String description, Boolean active, int page, int size) {
        if (page < 0)
            page = 0;
        PageRequest pagination = PageRequest.of(page, size);
        return this.classRepository.findByNameOrDescriptionAndActive(name, description, true, pagination)
                .map(this::entityBresponse);

    }
    private StudentResponse entitytiStudentResponse(StudentEntity student) {
        return StudentResponse.builder()
            .id(student.getId()).name(student.getName()).email(student.getEmail()).active(student.getActive()).created_at(student.getCreated_at()).build();
        
    }
    private LessonResponse entityIsLessonResponse(LessonEntity entity) {

        return LessonResponse.builder()
            .id(entity.getId()).title(entity.getTitle()).content(entity.getContent()).created_at(entity.getCreated_at()).build();
     }
}
