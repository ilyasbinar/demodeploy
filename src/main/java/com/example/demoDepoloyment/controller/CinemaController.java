package com.example.demoDepoloyment.controller;

import com.example.demoDepoloyment.model.Cinema;
import com.example.demoDepoloyment.payload.CinemaCreateRequestDto;
import com.example.demoDepoloyment.payload.CinemaDto;
import com.example.demoDepoloyment.service.CinemaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("cinema")
public class CinemaController {

    @Autowired
    private ModelMapper modelMapper;
    final
    CinemaService cinemaService;

    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }


    @GetMapping
    public List<Cinema> getAll(){
        return cinemaService.getAll();
    }

    @GetMapping("dto2")
    public List<CinemaDto> getAllDtos2(){
        return cinemaService.getAll().stream()
                .map(cinema -> modelMapper.map(cinema, CinemaDto.class))
                .toList();
    }

    @GetMapping("dto")
    public List<CinemaDto> getAllDtos(){
        return cinemaService.getAll().stream()
                .map(cinema -> modelMapper.map(cinema, CinemaDto.class))
                .toList();
    }

    @GetMapping("re")
    public ResponseEntity<Map<String, Object>> getAllRE(){
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");

        Map<String, Object> data = new HashMap<>();
        List<Cinema> cinemaList = cinemaService.getAll();
        List<CinemaDto> cinemaDtoList = cinemaList
                .stream()
                .map(cinema -> modelMapper.map(cinema, CinemaDto.class))
                .toList();
        data.put("cinemas", cinemaDtoList);

        response.put("data", data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/add")
    public  ResponseEntity<Map<String, Object>> add(@RequestBody CinemaCreateRequestDto cinemaCreateRequestDto){
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");

        Map<String, Object> data = new HashMap<>();
        data.put("cinema", cinemaService.create(cinemaCreateRequestDto));
        response.put("data", data);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
