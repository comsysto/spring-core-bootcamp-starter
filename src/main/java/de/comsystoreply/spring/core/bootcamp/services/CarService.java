package de.comsystoreply.spring.core.bootcamp.services;

import de.comsystoreply.spring.core.bootcamp.repositories.model.CarDto;
import de.comsystoreply.spring.core.bootcamp.repositories.model.CarEntity;
import de.comsystoreply.spring.core.bootcamp.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {

    private CarRepository repository;

    @Autowired
    public CarService(CarRepository repository){
        this.repository = repository;
    }

    public List<CarDto> findAll() {
        List<CarEntity> entities = this.repository.findAll();
        return entities.stream().map(CarDto::fromEntity).collect(Collectors.toList());
    }

    @Transactional
    public Long create(CarDto carDto) {
        return repository.save(CarEntity.fromDto(carDto)).getId();
    }

    public Long customCreate(CarDto carDto) {
        return create(carDto);
    }

    public CarDto findById(Long id) {
        Optional<CarEntity> result = this.repository.findById(id);
        return CarDto.fromEntity(result.orElseThrow(IllegalArgumentException::new));
    }

    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }

    public void update(Long id, CarDto carDto) {
        this.repository.save(CarEntity.fromDto(carDto));
    }
}
