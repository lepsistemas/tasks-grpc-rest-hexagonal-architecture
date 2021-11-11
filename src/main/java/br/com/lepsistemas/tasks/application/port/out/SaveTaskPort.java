package br.com.lepsistemas.tasks.application.port.out;

import br.com.lepsistemas.tasks.domain.Task;

public interface SaveTaskPort {

    Task save(Task task);
}
