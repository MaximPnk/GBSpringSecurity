package ru.pankov.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pankov.entity.User;
import ru.pankov.service.UserService;

import java.security.Principal;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // http://localhost:8189/get/1
    @GetMapping("/get/{id}")
    public Long findUserById(@PathVariable(value = "id") Long id) {
        return userService.findById(id).orElseThrow(() -> new RuntimeException("There is no user with id = " + id)).getScore();
    }

    // http://localhost:8189/inc
    @GetMapping("/inc")
    public String incrementUserScore(Principal principal) {
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("There is no user with user name " + principal.getName()));
        user.setScore(user.getScore() + 1);
        userService.saveOrUpdate(user);
        return "Success";
    }

    // http://localhost:8189/dec
    @GetMapping("/dec")
    public String decrementUserScore(Principal principal) {
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("There is no user with user name " + principal.getName()));
        user.setScore(user.getScore() - 1);
        userService.saveOrUpdate(user);
        return "Success";
    }
}
