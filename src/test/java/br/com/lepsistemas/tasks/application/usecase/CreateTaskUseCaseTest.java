package br.com.lepsistemas.tasks.application.usecase;

import br.com.lepsistemas.tasks.application.port.in.CreateTask;
import br.com.lepsistemas.tasks.application.port.in.CreateTaskCommand;
import br.com.lepsistemas.tasks.application.port.out.SaveTaskPort;
import br.com.lepsistemas.tasks.domain.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateTaskUseCaseTest {

    private CreateTask createTask;

    @Mock
    private SaveTaskPort persistence;

    @BeforeEach
    public void setUp() {
        createTask = new CreateTaskUseCase(persistence);
    }

    @Test
    public void shouldCreateTask() {
        var taskId = UUID.randomUUID();
        var taskBeforeSave = new Task(null, "Task 1");
        var taskAfterSave = new Task(taskId, "Task 1");
        when(persistence.save(taskBeforeSave)).thenReturn(taskAfterSave);

        var command = new CreateTaskCommand("Task 1");
        var createdTask = createTask.with(command);

        assertThat(createdTask).isEqualTo(new Task(taskId, "Task 1"));
    }

}