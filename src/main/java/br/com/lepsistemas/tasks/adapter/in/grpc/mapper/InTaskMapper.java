package br.com.lepsistemas.tasks.adapter.in.grpc.mapper;

import br.com.lepsistemas.tasks.common.annotations.MapperAdapter;
import br.com.lepsistemas.tasks.proto.common.messages.Task;
import com.google.common.base.Strings;

import java.util.UUID;

@MapperAdapter
public class InTaskMapper {

    public Task toProto(br.com.lepsistemas.tasks.domain.Task domain) {
        return Task.newBuilder()
                .setId(domain.id().toString())
                .setName(domain.name())
                .build();
    }

}
