package riwi.pruebadesempeno.prueba_desempeno.api.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import riwi.pruebadesempeno.prueba_desempeno.api.dto.request.ClassRequest;
import riwi.pruebadesempeno.prueba_desempeno.api.dto.request.StudentRequest;
import riwi.pruebadesempeno.prueba_desempeno.api.dto.response.ClassBasicResponse;
import riwi.pruebadesempeno.prueba_desempeno.api.dto.response.ClassResponse;
import riwi.pruebadesempeno.prueba_desempeno.api.dto.response.StudentResponse;
import riwi.pruebadesempeno.prueba_desempeno.infrastructure.abtracs_service.IClassService;

@RestController
@RequestMapping("/classs")
@Tag(name = "classes Controller")
@AllArgsConstructor

public class ClassController {
    private final IClassService service;

    @PostMapping
    public ResponseEntity<ClassResponse> createClass(@Validated ClassRequest request) {

        return ResponseEntity.ok(this.service.create(request));
    }
    @GetMapping
    public ResponseEntity <Page<ClassBasicResponse>> getStudent( @RequestParam(required = false) String name,@RequestParam(required = false) String description,
    @RequestParam(required = false) Boolean active, @RequestParam(defaultValue = "1") int page,
    @RequestParam(defaultValue = "5") int size) throws Exception {

                return ResponseEntity.ok(this.service.getAllin(name,description,active,page,size));
            }
    @GetMapping("/prueba")
   public ResponseEntity <Page<ClassResponse>>getall(@RequestParam(defaultValue = "1") int page,
   @RequestParam(defaultValue = "5") int size ){

    return ResponseEntity.ok(this.service.getAll(page,size));
   }
    @GetMapping(path = "/{id}")
    public ResponseEntity<ClassResponse> getid(@PathVariable Long id) {

        return ResponseEntity.ok(this.service.get(id));
    }
}
