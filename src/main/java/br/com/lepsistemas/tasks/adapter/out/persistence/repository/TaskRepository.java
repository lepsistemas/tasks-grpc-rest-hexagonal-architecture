package br.com.lepsistemas.tasks.adapter.out.persistence.repository;

import br.com.lepsistemas.tasks.adapter.out.persistence.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, String> {
}
