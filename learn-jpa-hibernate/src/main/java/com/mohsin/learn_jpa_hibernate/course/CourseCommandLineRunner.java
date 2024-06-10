package com.mohsin.learn_jpa_hibernate.course;

import com.mohsin.learn_jpa_hibernate.course.jdbc.CourseJdbcRepository;
import com.mohsin.learn_jpa_hibernate.course.jpa.CourseJpaRepository;
import com.mohsin.learn_jpa_hibernate.spring_data_jpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    @Autowired
    // private CourseJdbcRepository repository;
    // private CourseJpaRepository repository;
    private CourseSpringDataJpaRepository repository;

    // Allows the method execution to run at the startup of application
    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Learn DevOps---SpringDataJpa", "in28minutes"));
        repository.save(new Course(2, "Learn AWS---SpringDataJpa", "in28minutes"));
        repository.save(new Course(3, "Learn Azure---SpringDataJpa", "in28minutes"));

        repository.deleteById(1L);
        System.out.println(repository.findById(2L));
        System.out.println(repository.findById(3L));

        System.out.println(repository.findAll());
        System.out.println(repository.count());
        System.out.println(repository.findByAuthor("in28minutes2"));
        System.out.println(repository.findByName("Learn AWS---SpringDataJpa"));
    }
}
