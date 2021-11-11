package br.com.lepsistemas.tasks.application.usecase;

import br.com.lepsistemas.tasks.application.port.in.CreateTask;
import br.com.lepsistemas.tasks.application.port.in.CreateTaskCommand;
import br.com.lepsistemas.tasks.application.port.out.SaveTaskPort;
import br.com.lepsistemas.tasks.common.annotations.UseCaseAdapter;
import br.com.lepsistemas.tasks.domain.Task;
import lombok.RequiredArgsConstructor;

@UseCaseAdapter
@RequiredArgsConstructor
public class CreateTaskUseCase implements CreateTask {

    private final SaveTaskPort saveTaskPort;

    @Override
    public Task with(CreateTaskCommand command) {
        var newTask = new Task(null, command.name());
        return saveTaskPort.save(newTask);
    }
}
