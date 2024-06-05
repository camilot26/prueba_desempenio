package riwi.pruebadesempeno.prueba_desempeno.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import riwi.pruebadesempeno.prueba_desempeno.domain.entities.ClassEntity;

public interface ClassRepository extends JpaRepository<ClassEntity,Long>{
    
}
