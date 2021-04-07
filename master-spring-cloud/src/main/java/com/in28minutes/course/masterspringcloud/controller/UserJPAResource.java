package com.in28minutes.course.masterspringcloud.controller;

import com.in28minutes.course.masterspringcloud.controller.exception.UserNotFoundException;
import com.in28minutes.course.masterspringcloud.controller.model.Post;
import com.in28minutes.course.masterspringcloud.controller.model.User;
import com.in28minutes.course.masterspringcloud.repository.PostRepository;
import com.in28minutes.course.masterspringcloud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/jpa")
public class UserJPAResource {

    private final MessageSource messageSource;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Autowired
    public UserJPAResource(UserRepository userRepository, MessageSource messageSource, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.messageSource = messageSource;
        this.postRepository = postRepository;
    }

    //GET /users
    //retrieveAllUsers
    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    // GET /users/{id}
    // retrieveUser(id)
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("id: " + id));
    }

    @PostMapping("/users")
    public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {
        User savedUser = userRepository.save(user);

        // The URI to access to created user
        URI localtion = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        // The location will be in the response header
        // HTTP 201 Created code will be returned
        return ResponseEntity.created(localtion).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("id: " + id));

        userRepository.deleteById(id);
    }

    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized() {
        return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
    }

    @PostMapping("/users/{userId}/posts")
    public ResponseEntity<Post> createPost(@PathVariable int userId, @RequestBody Post postDto) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("id: " + userId));

        Post savedPost = postRepository.save(postDto);

        savedPost.setUser(user);
        user.getPosts().add(savedPost);

        postRepository.save(savedPost);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
