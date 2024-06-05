package riwi.pruebadesempeno.prueba_desempeno.domain.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import riwi.pruebadesempeno.prueba_desempeno.domain.entities.ClassEntity;

public interface ClassRepository extends JpaRepository<ClassEntity,Long>{
        Page<ClassEntity> findByNameOrDescriptionAndActive(String name, String descripcion,Boolean active,PageRequest request);
}
