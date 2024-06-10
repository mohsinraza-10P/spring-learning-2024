package com.mohsin.restful_web_services.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostDaoService {
    @Autowired
    private PostRepository repository;

    public Post save(Post post) {
        return repository.save(post);
    }
}
