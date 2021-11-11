package br.com.lepsistemas.tasks.adapter.in.grpc;

import br.com.lepsistemas.tasks.adapter.in.grpc.mapper.InTaskMapper;
import br.com.lepsistemas.tasks.application.port.in.CreateTask;
import br.com.lepsistemas.tasks.application.port.in.CreateTaskCommand;
import br.com.lepsistemas.tasks.common.annotations.GrpcAdapter;
import br.com.lepsistemas.tasks.proto.rpc.tasks.CreateTaskRequest;
import br.com.lepsistemas.tasks.proto.rpc.tasks.CreateTaskResponse;
import br.com.lepsistemas.tasks.proto.rpc.tasks.TasksGrpc.TasksImplBase;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;

@GrpcAdapter
@RequiredArgsConstructor
public class TasksGrpc extends TasksImplBase {

    private final CreateTask createTask;
    private final InTaskMapper mapper;

    @Override
    public void create(CreateTaskRequest request, StreamObserver<CreateTaskResponse> responseObserver) {
        var command = new CreateTaskCommand(request.getName());
        var createdTask = createTask.with(command);
        var response = CreateTaskResponse.newBuilder().setTask(mapper.toProto(createdTask)).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
