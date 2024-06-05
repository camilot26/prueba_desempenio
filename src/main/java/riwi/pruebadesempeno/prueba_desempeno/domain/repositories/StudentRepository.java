package riwi.pruebadesempeno.prueba_desempeno.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import riwi.pruebadesempeno.prueba_desempeno.domain.entities.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity,Long>{
    
    List<StudentEntity> findByNameOrDescriptionAndActiveTrue(String name, String description);
}
