package br.com.lepsistemas.tasks.adapter.out.persistence;

import br.com.lepsistemas.tasks.adapter.out.persistence.entity.TaskEntity;
import br.com.lepsistemas.tasks.adapter.out.persistence.mapper.OutTaskMapper;
import br.com.lepsistemas.tasks.adapter.out.persistence.repository.TaskRepository;
import br.com.lepsistemas.tasks.domain.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class TaskPersistenceTest {

    private TaskPersistence persistence;

    @Mock
    private TaskRepository repository;

    private OutTaskMapper mapper;

    @BeforeEach
    public void setUp() {
        persistence = new TaskPersistence(new OutTaskMapper(), repository);
    }

    @Test
    public void shouldSaveTask() {
        var task = new Task(null, "Task 1");

        var entity = TaskEntity.builder().name("Task 1").build();
        var taskId = UUID.randomUUID();
        var savedEntity = TaskEntity.builder().id(taskId).name("Task 1").build();
        Mockito.when(repository.save(entity)).thenReturn(savedEntity);

        var result = persistence.save(task);

        assertThat(result).isEqualTo(new Task(taskId, "Task 1"));
    }

}