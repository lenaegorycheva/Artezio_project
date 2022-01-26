package ru.egorycheva.springapp1.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.egorycheva.springapp1.models.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Student student = new Student();
        student.setId(resultSet.getInt("student_id"));
        student.setSurname(resultSet.getString("surname"));
        student.setName(resultSet.getString("name"));
        student.setPatronymic(resultSet.getString("patronymic"));
        student.setAge(resultSet.getInt("age"));
        student.setIdGroup(resultSet.getInt("group_id"));
        student.setPhone(resultSet.getString("phone"));
        student.setEmail(resultSet.getString("email"));
        student.setNameGroup(resultSet.getString("name_group"));
        return student;
    }
}
