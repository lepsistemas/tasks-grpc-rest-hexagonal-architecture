package br.com.lepsistemas.tasks.adapter.in.grpc;

import br.com.lepsistemas.tasks.adapter.in.grpc.mapper.InTaskMapper;
import br.com.lepsistemas.tasks.application.port.in.CreateTask;
import br.com.lepsistemas.tasks.application.port.in.CreateTaskCommand;
import br.com.lepsistemas.tasks.proto.common.messages.Task;
import br.com.lepsistemas.tasks.proto.rpc.tasks.CreateTaskRequest;
import br.com.lepsistemas.tasks.proto.rpc.tasks.CreateTaskResponse;
import io.grpc.stub.StreamObserver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TasksGrpcTest {

    @Mock
    private CreateTask createTask;

    @Mock
    StreamObserver<CreateTaskResponse> streamObserver;

    private TasksGrpc tasksGrpc;

    @BeforeEach
    public void setUp() {
        tasksGrpc = new TasksGrpc(createTask, new InTaskMapper());
    }

    @Test
    public void shouldCreateTask() {
        var taskId = UUID.randomUUID();
        when(createTask.with(new CreateTaskCommand("Task 1"))).thenReturn(new br.com.lepsistemas.tasks.domain.Task(taskId, "Task 1"));

        var request = CreateTaskRequest.newBuilder().setName("Task 1").build();
        tasksGrpc.create(request, streamObserver);

        var response = CreateTaskResponse.newBuilder().setTask(Task.newBuilder().setId(taskId.toString()).setName("Task 1").build()).build();
        verify(streamObserver).onNext(response);
        verify(streamObserver).onCompleted();
    }

}