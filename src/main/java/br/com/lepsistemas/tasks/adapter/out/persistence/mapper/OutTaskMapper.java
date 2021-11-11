package br.com.lepsistemas.tasks.adapter.out.persistence.mapper;

import br.com.lepsistemas.tasks.adapter.out.persistence.entity.TaskEntity;
import br.com.lepsistemas.tasks.common.annotations.MapperAdapter;
import br.com.lepsistemas.tasks.domain.Task;
import com.google.common.base.Strings;

import java.util.UUID;

@MapperAdapter
public class OutTaskMapper {

    public TaskEntity toEntity(Task domain) {
        return TaskEntity.builder()
                .id(domain.id() == null ? null : domain.id())
                .name(domain.name())
                .build();
    }

    public Task toDomain(TaskEntity entity) {
        return new Task(entity.getId(), entity.getName());
    }

}
