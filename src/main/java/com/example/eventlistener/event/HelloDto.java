package com.example.eventlistener.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HelloDto {

    private Long id;
    private String name;

    public static HelloDto toDto(HelloEntity helloEntity) {
        return HelloDto.builder()
            .id(helloEntity.getId())
            .name(helloEntity.getName())
            .build();
    }
}
