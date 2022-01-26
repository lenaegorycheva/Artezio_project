package ru.egorycheva.springapp1.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.egorycheva.springapp1.models.AcademicGroup;
import ru.egorycheva.springapp1.models.Student;
import java.util.List;

@Component
public class StudentDAO {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public StudentDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Student> getStudents() {
        return jdbcTemplate.query("SELECT s.surname, s.name, s.patronymic, s.student_id, s.group_id, g.name_group, s.age, s.phone, s.email FROM artezio_project.students s LEFT JOIN artezio_project.academic_groups g ON s.group_id=g.group_id ORDER BY s.surname, s.name, s.patronymic", new StudentMapper());
    }

    public Student showStudent(int id){
        return jdbcTemplate.query("SELECT s.surname, s.name, s.patronymic, s.student_id, s.group_id, g.name_group, s.age, s.phone, s.email FROM artezio_project.students s INNER JOIN artezio_project.academic_groups g ON s.group_id=g.group_id WHERE student_id = ?", new Object[]{id}, new StudentMapper()).stream().findAny().orElse(null);
    }

    public void saveStudent(Student student){
        jdbcTemplate.update("INSERT INTO artezio_project.students (surname, name, patronymic, age, group_id, phone, email) VALUES(?,?,?,?,?,?,?) ", student.getSurname(), student.getName(), student.getPatronymic(), student.getAge(), student.getIdGroup(), student.getPhone(), student.getEmail());
    }

    public void updateStudent(int id, Student updateStudent){
        jdbcTemplate.update("UPDATE artezio_project.students SET surname = ?, name = ?, patronymic = ?, age = ?, group_id = ?, phone = ?, email = ? WHERE student_id = ?", updateStudent.getSurname(), updateStudent.getName(), updateStudent.getPatronymic(), updateStudent.getAge(), updateStudent.getIdGroup(), updateStudent.getPhone(), updateStudent.getEmail(), id);
    }

    public List<AcademicGroup> getGroups(){
        return jdbcTemplate.query("SELECT * FROM artezio_project.academic_groups", new GroupMapper());
    }

    public void deleteStudent(int id){
        jdbcTemplate.update("DELETE FROM artezio_project.students WHERE student_id = ?", id);
    }
}
