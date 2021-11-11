package br.com.lepsistemas.tasks.application.port.in;

import br.com.lepsistemas.tasks.domain.Task;

public interface CreateTask {

    Task with(CreateTaskCommand command);
}
