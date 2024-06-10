package com.mohsin.restful_web_services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDaoService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findOne(int id) {
        return repository.findById(id).orElse(null);
    }

    public User save(User user) {
        return repository.save(user);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
