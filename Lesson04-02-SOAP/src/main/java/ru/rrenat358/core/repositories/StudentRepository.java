package ru.rrenat358.core.repositories;

import ru.rrenat358.core.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    @Query("select s from StudentEntity s where s.name = ?1")
    Optional<StudentEntity> findByName(String name);
}
