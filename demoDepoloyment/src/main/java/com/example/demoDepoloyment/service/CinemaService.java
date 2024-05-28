package com.example.demoDepoloyment.service;


import com.example.demoDepoloyment.model.Cinema;
import com.example.demoDepoloyment.payload.CinemaCreateRequestDto;
import com.example.demoDepoloyment.payload.CinemaDto;

import java.util.List;
import java.util.UUID;

public interface CinemaService {

    List<Cinema> getAll();

    void updateAddress(Cinema cinema, String address);

    void deleteCinema(Cinema cinema);

    CinemaDto create(CinemaCreateRequestDto cinemaCreateRequestDto);

    Cinema update(UUID id, Cinema cinema);
}
