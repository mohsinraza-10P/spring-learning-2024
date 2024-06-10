package com.mohsin.learn_jpa_hibernate.course.jdbc;

import com.mohsin.learn_jpa_hibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final String INSERT_QUERY = """
                INSERT INTO COURSE (ID, NAME, AUTHOR) VALUES (?, ?, ?);
            """;
    private final String DELETE_QUERY = """
                DELETE FROM COURSE WHERE ID = ?;
            """;
    private final String SELECT_QUERY = """
                SELECT * FROM COURSE WHERE ID = ?;
            """;

    public void insert(Course course) {
        jdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void delete(long courseId) {
        jdbcTemplate.update(DELETE_QUERY, courseId);
    }

    public Course find(long courseId) {
        return jdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), courseId);
    }
}
