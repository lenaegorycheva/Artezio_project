package ru.egorycheva.springapp1.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.egorycheva.springapp1.models.AcademicGroup;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupMapper implements RowMapper<AcademicGroup> {
    @Override
    public AcademicGroup mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        AcademicGroup academicGroup = new AcademicGroup();
        academicGroup.setId(resultSet.getInt("group_id"));
        academicGroup.setName(resultSet.getString("name_group"));
        academicGroup.setFaculty(resultSet.getString("faculty"));
        academicGroup.setDateStart(resultSet.getInt("date_start"));
        academicGroup.setQtYear(resultSet.getInt("qt_year"));
        return academicGroup;
    }
}
