package com.project.msoauth.resources;

import com.project.msoauth.entities.User;
import com.project.msoauth.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserResource {

    private final UserService userService;

    @GetMapping(value = "/search")
    @ResponseStatus(HttpStatus.OK)
    public User findUserByEmail(@RequestParam String email) {
        User user = userService.findUserByEmail(email);
        return user;
    }

}
