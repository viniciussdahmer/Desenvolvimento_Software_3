package com.example.desenvolvimento_software_3.application.user;


import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/users")
public class UserRestAPI {

    private final UserService userService;

    public UserRestAPI(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ResponseBody
    public Page<UserDTO> getAll(Pageable pageable) {
        return userService.getAll(pageable).map(UserBuilder::fromEntity);
    }
}
