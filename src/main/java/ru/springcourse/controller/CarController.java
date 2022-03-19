package ru.springcourse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.springcourse.dao.CarDAO;
import ru.springcourse.domain.Car;

import javax.validation.Valid;

@Controller
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarDAO carDAO;

    public CarController(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("cars", this.carDAO.getAll());
        return "/cars/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("car", this.carDAO.get(id));
        return "/cars/show";
    }

    @GetMapping("/new")
    public String newCar(@ModelAttribute("car") Car car) {
        return "cars/new";
    }

    @PostMapping
    public String create(@ModelAttribute("car") @Valid Car car, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "cars/new";
        }

        this.carDAO.save(car);
        return "redirect:/cars";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("car", carDAO.get(id));
        return "/cars/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("car") @Valid Car car, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "cars/new";
        }

        this.carDAO.update(id, car);
        return "redirect:/cars";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        this.carDAO.delete(id);
        return "redirect:/cars";
    }
}