package br.com.lepsistemas.tasks.adapter.in.grpc.mapper;

import br.com.lepsistemas.tasks.proto.common.messages.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class InTaskMapperTest {

    private InTaskMapper mapper;

    @BeforeEach
    public void setUp() {
        mapper = new InTaskMapper();
    }

    @Test
    public void shouldConvertToProto() {
        var taskId = UUID.randomUUID();
        var domain = new br.com.lepsistemas.tasks.domain.Task(taskId, "Task 1");

        var result = mapper.toProto(domain);

        assertThat(result).isEqualTo(Task.newBuilder().setId(taskId.toString()).setName("Task 1").build());
    }

}