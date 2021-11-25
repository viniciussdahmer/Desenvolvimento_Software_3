package com.example.desenvolvimento_software_3.application.sintoma;

import com.example.desenvolvimento_software_3.application.user.User;
import com.example.desenvolvimento_software_3.application.user.UserDTO;

public class SintomaDTO {

    private String description;
    private String dateTime;
    private UserDTO userDTO;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO user) {
        this.userDTO = user;
    }
}
