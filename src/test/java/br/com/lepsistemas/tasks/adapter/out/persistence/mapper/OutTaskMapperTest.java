package br.com.lepsistemas.tasks.adapter.out.persistence.mapper;

import br.com.lepsistemas.tasks.adapter.out.persistence.entity.TaskEntity;
import br.com.lepsistemas.tasks.domain.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class OutTaskMapperTest {

    private OutTaskMapper mapper;

    @BeforeEach
    public void setUp() {
        mapper = new OutTaskMapper();
    }

    @Test
    public void shouldConvertToEntity() {
        var taskId = UUID.randomUUID();
        var domain = new Task(taskId, "Task 1");

        var result = mapper.toEntity(domain);

        assertThat(result).isEqualTo(TaskEntity.builder().id(taskId).name("Task 1").build());
    }

    @Test
    public void shouldConvertToDomain() {
        var taskId = UUID.randomUUID();
        var entity = TaskEntity.builder().id(taskId).name("Task 1").build();

        var result = mapper.toDomain(entity);

        assertThat(result).isEqualTo(new Task(taskId, "Task 1"));
    }

}