package com.example.desenvolvimento_software_3.application.user;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

public interface UserService {

    Page<User> getAll(Pageable pageable);
}
