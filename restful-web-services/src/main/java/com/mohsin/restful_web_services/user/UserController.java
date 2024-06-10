package com.mohsin.restful_web_services.user;

import com.mohsin.restful_web_services.post.Post;
import com.mohsin.restful_web_services.post.PostDaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserDaoService userService;

    @Autowired
    private PostDaoService postService;

    // GET - /users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    // GET - /users/{id}
    @GetMapping("/{id}")
    public EntityModel<User> getUser(@PathVariable int id) {
        User user = findUser(id);
        var entityModel = EntityModel.of(user);
        var link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }

    // POST - /users
    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        var savedUser = userService.save(user);
        var location = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).body(savedUser);
    }

    // DELETE - /users/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable int id) {
        userService.deleteById(id);
        return ResponseEntity.ok(null);
    }

    // GET - /users/{id}/posts
    @GetMapping("/{id}/posts")
    public List<Post> getUserPosts(@PathVariable int id) {
        User user = findUser(id);
        return user.getPosts();
    }

    // POST - /users/{id}/posts
    @PostMapping("/{id}/posts")
    public ResponseEntity<Post> createPost(@PathVariable int id, @Valid @RequestBody Post post) {
        User user = findUser(id);
        post.setUser(user);
        var savedPost = postService.save(post);
        var location = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();
        return ResponseEntity.created(location).body(savedPost);
    }

    private User findUser(int id) {
        var user = userService.findOne(id);
        if (user == null) {
            throw new UserNotFoundException("We could not find any user with id: " + id);
        }
        return user;
    }
}
