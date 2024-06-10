package com.mohsin.learn_jpa_hibernate.course.jpa;

import com.mohsin.learn_jpa_hibernate.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Course course) {
        entityManager.merge(course);
    }

    public void delete(long courseId) {
        var course = find(courseId);
        entityManager.remove(course);
    }

    public Course find(long courseId) {
        return entityManager.find(Course.class, courseId);
    }
}
