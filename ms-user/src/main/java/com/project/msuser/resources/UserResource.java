package com.project.msuser.resources;

import com.project.msuser.entities.User;
import com.project.msuser.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserResource {

    private final UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User findUserById(@PathVariable Long id) {
        User user = userService.findUserById(id);
        return user;
    }

    @GetMapping(value = "/search")
    @ResponseStatus(HttpStatus.OK)
    public User findUserByEmail(@RequestParam String email) {
        User user = userService.findUserByEmail(email);
        return user;
    }

}
