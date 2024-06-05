package riwi.pruebadesempeno.prueba_desempeno.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import riwi.pruebadesempeno.prueba_desempeno.api.dto.request.ClassRequest;
import riwi.pruebadesempeno.prueba_desempeno.api.dto.request.StudentRequest;
import riwi.pruebadesempeno.prueba_desempeno.api.dto.response.ClassResponse;
import riwi.pruebadesempeno.prueba_desempeno.api.dto.response.StudentResponse;
import riwi.pruebadesempeno.prueba_desempeno.infrastructure.abtracs_service.IClassService;

@RestController
@RequestMapping("/classs")
@Tag(name="classes Controller")
@AllArgsConstructor

public class ClassController {
    private final IClassService service;

    @PostMapping
    public ResponseEntity<ClassResponse> createClass(@Validated ClassRequest request) {

                return ResponseEntity.ok(this.service.create(request));
        }   
    



}
