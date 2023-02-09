package co.develhope.crud.controllers;

import co.develhope.crud.entities.Car;
import co.develhope.crud.repositories.CarRepository;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    // Create a new Car
    @PostMapping("")
    public Car createCar(@RequestBody Car car){
        return carRepository.save(car);
    }

    // Return a list of all the Cars
    @GetMapping("")
    public List<Car> getAllCars(){
        return carRepository.findAll();
    }

    // return a single Car by id
    @GetMapping("/{id}")
    public Car getACarById(@PathVariable long id){
        if(carRepository.existsById(id)){
            return carRepository.getById(id);
        }
        return new Car();
    }

    // Updates the type of a specific Car by id
    @PutMapping("/{id}")
    public Car updateTypeOfTheCar(@PathVariable long id, @RequestParam String type){
        Car car;
        if (carRepository.existsById(id)){
            car = carRepository.getById(id);
            car.setType(type);
            car = carRepository.saveAndFlush(car);
        }else{
            car = new Car();
        }
        return car;
    }

    // deletes a specific Car by id
    @DeleteMapping("/{id}")
    public void deleteCarById(@PathVariable long id, HttpServletResponse response){
        if (carRepository.existsById(id))
            carRepository.deleteById(id);
        else
            response.setStatus(409);
    }

    // delete all
    @DeleteMapping("")
    public void deleteAll(){
        carRepository.deleteAll();
    }

}
