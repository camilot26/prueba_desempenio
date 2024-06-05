package riwi.pruebadesempeno.prueba_desempeno.domain.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;


import riwi.pruebadesempeno.prueba_desempeno.domain.entities.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity,Long>{
    
    Page<StudentEntity> findByNameOrActive(String name, Boolean active,PageRequest request);
}
