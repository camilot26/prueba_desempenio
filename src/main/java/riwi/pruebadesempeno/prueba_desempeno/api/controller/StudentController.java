package riwi.pruebadesempeno.prueba_desempeno.api.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import riwi.pruebadesempeno.prueba_desempeno.api.dto.request.StudentRequest;
import riwi.pruebadesempeno.prueba_desempeno.api.dto.response.StudentBasicResponse;
import riwi.pruebadesempeno.prueba_desempeno.api.dto.response.StudentResponse;
import riwi.pruebadesempeno.prueba_desempeno.infrastructure.abtracs_service.IStudentService;

@RestController
@RequestMapping("/students")
@Tag(name = "students Controller")
@AllArgsConstructor
public class StudentController {
        private final IStudentService studentservice;

        @GetMapping
        public ResponseEntity<Page<StudentResponse>> getAllStudents(@RequestParam(required = false) String name,
                        @RequestParam(required = false) Boolean active, @RequestParam(defaultValue = "1") int page,
                        @RequestParam(defaultValue = "5") int size) {

                return ResponseEntity.ok(this.studentservice.getAll(page, size, name));
        }

        @GetMapping(path = "/{id}")
        public ResponseEntity<Object> getStudent(@PathVariable Long id) {

                return ResponseEntity.ok(this.studentservice.getid(id));
        }
        @PostMapping
        public ResponseEntity<StudentResponse> createStudent(@Validated StudentRequest request) {

                return ResponseEntity.ok(this.studentservice.create(request));
        }       
        @PatchMapping(path = "/{id}/disable")
        public ResponseEntity<StudentResponse> disableStudent(@PathVariable Long id) {

                this.studentservice.delete(id);
                return ResponseEntity.noContent().build();
        }
        @PutMapping(path="/{id}")
        public ResponseEntity<StudentResponse> updateStudent(@Validated StudentRequest request, @PathVariable Long id) {

                return ResponseEntity.ok(this.studentservice.update(request, id));
        }
}
