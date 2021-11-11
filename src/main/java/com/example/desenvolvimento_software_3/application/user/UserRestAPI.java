package com.example.desenvolvimento_software_3.application.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    @ResponseBody
    public UserDTO create(@RequestBody UserDTO userDTO) {
        return UserBuilder.fromEntity(userService.create(UserBuilder.fromDTO(userDTO)));
    }

    @GetMapping("/{id}")
    @ResponseBody
    public UserDTO getOne(@PathVariable Long id) throws Exception {
        return UserBuilder.fromEntity(userService.getOne(id));
    }

    @PutMapping("/{userId}/update")
    public UserDTO update(@RequestBody UserDTO userDTO, @PathVariable Long userId) {
        return UserBuilder.fromEntity(userService.update(UserBuilder.fromDTO(userDTO), userId));
    }

    @DeleteMapping("/{id}/delete")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) throws Exception {
        userService.delete(id);
    }

}
