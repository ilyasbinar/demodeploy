package com.example.demoDepoloyment.service;

import com.example.demoDepoloyment.model.Cinema;
import com.example.demoDepoloyment.payload.CinemaCreateRequestDto;
import com.example.demoDepoloyment.payload.CinemaDto;
import com.example.demoDepoloyment.repository.CinemaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CinemaServiceImpl implements CinemaService {
    @Autowired
    CinemaRepository cinemaRepository;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public List<Cinema> getAll() {
        return cinemaRepository.findAll();
    }

    @Override
    public void updateAddress(Cinema cinema, String address) {
        cinema.setAddress(address);
        cinemaRepository.save(cinema);
    }

    @Override
    public void deleteCinema(Cinema cinema) {
        cinemaRepository.delete(cinema);
    }

    @Override
    public CinemaDto create(CinemaCreateRequestDto cinemaCreateRequestDto) {
        Cinema cinema = new Cinema();
        cinema.setName(cinemaCreateRequestDto.getName());
        cinema.setAddress(cinemaCreateRequestDto.getAddress());
        cinemaRepository.save(cinema);

        return modelMapper.map(cinema, CinemaDto.class);
    }

    @Override
    public Cinema update(UUID id, Cinema cinema) {
        cinema.setId(id);
        return cinemaRepository.save(cinema);
    }
}
