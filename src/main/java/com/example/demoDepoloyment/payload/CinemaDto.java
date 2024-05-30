package com.example.demoDepoloyment.payload;

import lombok.Data;

import java.util.UUID;

@Data
public class CinemaDto {
    private UUID id;

    private String name;
    private String address;
}
