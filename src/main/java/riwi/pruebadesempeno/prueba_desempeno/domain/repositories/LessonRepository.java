package riwi.pruebadesempeno.prueba_desempeno.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import riwi.pruebadesempeno.prueba_desempeno.domain.entities.LessonEntity;

public interface LessonRepository extends JpaRepository<LessonEntity,Long> {

}
