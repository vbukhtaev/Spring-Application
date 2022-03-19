package ru.springcourse.domain;

import javax.validation.constraints.*;

public class Car {

    private int id;

    @NotEmpty(message = "Название производителя должно быть указано!")
    @Size(min = 2, max = 30, message = "Название производителя должно быть от 2 до 30 символов!")
    private String manufacturer;

    @NotEmpty(message = "Название модели должно быть указано!")
    @Size(min = 2, max = 30, message = "Название модели должно быть от 2 до 30 символов!")
    private String model;

    @Min(value = 1920, message = "Год должен быть больше 1919 !")
    @Max(value = 2022, message = "Год должен быть меньше 2023 !")
    private int year;

    @NotEmpty(message = "Номер должен быть указан!")
    @Pattern(regexp = "\\b\\w\\d{3}\\w{2}\\d{2,3}\\b")
    private String number;

    public Car() {
    }

    public Car(int id, String manufacturer, String model, int year, String number) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
