package ru.egorycheva.springapp1.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class AcademicGroup {
    private int id;

    @NotEmpty(message = "Это поле не должно быть пустым!")
    @Size(max = 15, message = "Название группы не должно быть длинее 15 символов!")
    private String name;

    @Size(max = 15, message = "Название факультета не должно быть длинее 45 символов!")
    private String faculty;

    @Min(value = 2000, message = "Год должен быть больше 2000!")
    private int dateStart;

    @Min(value = 4, message = "Длительность обучения не может быть менее 4 лет")
    @Max(value = 6, message = "Длительность обучения не может быть более 6 лет")
    private int qtYear;

    public AcademicGroup() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getDateStart() {
        return dateStart;
    }

    public void setDateStart(int dateStart) {
        this.dateStart = dateStart;
    }

    public int getQtYear() {
        return qtYear;
    }

    public void setQtYear(int qtYear) {
        this.qtYear = qtYear;
    }
}
