package com.example.desenvolvimento_software_3.application.user;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User create(User user);

    User getOne(Long id) throws Exception;

    User update(User fromDTO, Long userId);

    void delete(Long id);
}
