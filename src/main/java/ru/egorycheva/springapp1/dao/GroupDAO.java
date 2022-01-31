package ru.egorycheva.springapp1.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.egorycheva.springapp1.models.AcademicGroup;
import java.util.List;

@Component
public class GroupDAO {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public GroupDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<AcademicGroup> getGroups(){
        return jdbcTemplate.query("SELECT * FROM artezio_project.academic_groups ORDER BY faculty, name_group", new GroupMapper());
    }

    public AcademicGroup showGroup(int id){
        return jdbcTemplate.query("SELECT * FROM artezio_project.academic_groups WHERE group_id = ?", new Object[]{id}, new GroupMapper()).stream().findAny().orElse(null);
    }

    public void saveGroup(AcademicGroup group){
        jdbcTemplate.update("INSERT INTO artezio_project.academic_groups (name_group, faculty, date_start, qt_year) VALUES(?,?,?,?) ", group.getName(), group.getFaculty(), group.getDateStart(), group.getQtYear());
    }

    public void updateGroup(int id, AcademicGroup updateGroup){
        jdbcTemplate.update("UPDATE artezio_project.academic_groups SET name_group = ?, faculty = ?, date_start = ?, qt_year = ? WHERE group_id = ?", updateGroup.getName(), updateGroup.getFaculty(), updateGroup.getDateStart(), updateGroup.getQtYear(), id);
    }

    public void deleteGroup(int id){
        jdbcTemplate.update("DELETE FROM artezio_project.academic_groups WHERE group_id = ?", id);
    }
}
