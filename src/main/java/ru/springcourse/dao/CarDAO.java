package ru.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.springcourse.domain.Car;

import java.util.List;

@Component
public class CarDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CarDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Car> getAll() {
        return jdbcTemplate.query("SELECT * FROM car", new BeanPropertyRowMapper<>(Car.class));
    }

    public Car get(int id) {
        return jdbcTemplate.query("SELECT * FROM car WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Car.class))
                .stream().findAny().orElse(null);
    }

    public void save(Car car) {
        jdbcTemplate.update("INSERT INTO car(manufacturer, model, year, number) VALUES (?, ?, ?, ?)",
                car.getManufacturer(),
                car.getModel(),
                car.getYear(),
                car.getNumber());
    }

    public void update(int id, Car updatedCar) {
        jdbcTemplate.update("UPDATE car SET manufacturer=?, model=?, year=?, number=? WHERE id=?",
                updatedCar.getManufacturer(),
                updatedCar.getModel(),
                updatedCar.getYear(),
                updatedCar.getNumber(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM car WHERE id=?", id);
    }
}
