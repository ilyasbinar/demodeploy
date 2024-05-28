package com.example.demoDepoloyment;

import org.springframework.web.bind.annotation.*;

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
}
