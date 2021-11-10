package com.example.desenvolvimento_software_3.application.user;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserRestAPI {

    private final UserService userService;

    public UserRestAPI(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ResponseBody
    public List<UserDTO> getAll() {
        return userService.getAll().stream().map(UserBuilder::fromEntity).collect(Collectors.toList());
    }
}
