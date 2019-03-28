package de.comsystoreply.spring.core.bootcamp.controller;

import de.comsystoreply.spring.core.bootcamp.repositories.model.CarDto;
import de.comsystoreply.spring.core.bootcamp.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/cars", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }


    @GetMapping
    public List<CarDto> listAll() {
        return this.carService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDto> findById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(this.carService.findById(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity create(@RequestBody CarDto carDto, UriComponentsBuilder uriComponentsBuilder) {
        Long id = carService.create(carDto);
        return ResponseEntity
                .created(uriComponentsBuilder.path("/cars/{id}")
                        .buildAndExpand(id).toUri())
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long id){
        try {
            carService.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException | EmptyResultDataAccessException e ) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") Long id,
        @RequestBody CarDto carDto) {
        try {
            carService.update(id, carDto);
            return ResponseEntity.ok().build();
        } catch () {
            return ResponseEntity.notFound().build();
        }
    }

}
