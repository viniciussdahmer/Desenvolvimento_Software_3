package com.example.desenvolvimento_software_3.application.user;

import com.example.desenvolvimento_software_3.application.sintoma.Sintoma;
import com.example.desenvolvimento_software_3.application.sintoma.SintomaBuilder;

import java.util.stream.Collectors;

public class UserBuilder {

    public static User fromDTO(UserDTO userDTO) {
        return build(userDTO);
    }

    public static UserDTO fromEntity(User user) {
        return build(user);
    }

    private static User build(UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setCep(userDTO.getCep());
        user.setCidade(userDTO.getCidade());
        user.setEstado(userDTO.getEstado());
        user.setLogradouro(userDTO.getLogradouro());
        user.setSenha(userDTO.getSenha());
        return user;
    }

    private static UserDTO build(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setCep(user.getCep());
        userDTO.setCidade(user.getCidade());
        userDTO.setEstado(user.getEstado());
        userDTO.setLogradouro(user.getLogradouro());
        userDTO.setSenha(user.getSenha());
        userDTO.setSintomas(user.getSintomas().stream().map(SintomaBuilder::fromEntity).collect(Collectors.toList()));
        return userDTO;
    }
}
