package ru.rrenat358.core.repositories;

import ru.rrenat358.core.entities.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<GroupEntity, Long> {
    @Query("select g from GroupEntity g where g.title = ?1")
    Optional<GroupEntity> findByTitle(String title);
}
