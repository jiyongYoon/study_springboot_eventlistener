package com.example.eventlistener.event;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class HelloEvent {
    private Long id;
    private String name;

    public static HelloEntity toEntity(HelloEvent helloEvent) {
        return HelloEntity.builder()
            .id(helloEvent.getId())
            .name(helloEvent.getName())
            .build();
    }
}
