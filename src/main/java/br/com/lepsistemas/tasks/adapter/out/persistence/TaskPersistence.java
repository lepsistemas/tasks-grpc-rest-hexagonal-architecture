package br.com.lepsistemas.tasks.adapter.out.persistence;

import br.com.lepsistemas.tasks.adapter.out.persistence.mapper.OutTaskMapper;
import br.com.lepsistemas.tasks.adapter.out.persistence.repository.TaskRepository;
import br.com.lepsistemas.tasks.application.port.out.SaveTaskPort;
import br.com.lepsistemas.tasks.common.annotations.PersistenceAdapter;
import br.com.lepsistemas.tasks.domain.Task;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class TaskPersistence implements SaveTaskPort {

    private final OutTaskMapper mapper;
    private final TaskRepository repository;

    @Override
    public Task save(Task task) {
        var entity = mapper.toEntity(task);
        var savedEntity = repository.save(entity);
        return mapper.toDomain(savedEntity);
    }
}
