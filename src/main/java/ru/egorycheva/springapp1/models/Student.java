package ru.egorycheva.springapp1.models;


import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Student{
    private int id;

    @NotEmpty(message = "Это поле не должно быть пустым!")
    @Size(max = 45, message = "Длина фамилии не должна превышать 45 символов!")
    private String surname;

    @NotEmpty(message = "Это поле не должно быть пустым!")
    @Size(min = 2, max = 30, message = "Длина имени не должна быть менее 2 и более 30 символов!")
    private String name;

    @Size(max = 30, message = "Длина отчества не должна превышать 30 символов!")
    private String patronymic;

    @Min(value = 1, message = "Возраст должен быть больше 0!")
    private int age;

    @Size(min =  11, max = 11, message = "Длина номера телефона должна содержать 11 символов!")
    private String phone;

    @Email(message = "Некорректный email!")
    private String email;

    private int idGroup;

    private String nameGroup;

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }
}
