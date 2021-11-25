package com.example.desenvolvimento_software_3.application.sintoma;

import com.example.desenvolvimento_software_3.application.user.UserBuilder;

public class SintomaBuilder {

    public static Sintoma fromDTO(SintomaDTO sintomaDTO) {
        return build(sintomaDTO);
    }

    public static SintomaDTO fromEntity(Sintoma sintoma) {
        return build(sintoma);
    }

    private static Sintoma build(SintomaDTO sintomaDTO) {
        Sintoma sintoma = new Sintoma();
        sintoma.setDateTime(sintomaDTO.getDateTime());
        sintoma.setDescription(sintomaDTO.getDescription());
        //sintoma.setUser(UserBuilder.fromDTO(sintomaDTO.getUserDTO()));
        return sintoma;
    }

    private static SintomaDTO build(Sintoma sintoma) {
        SintomaDTO sintomaDTO = new SintomaDTO();
        sintomaDTO.setDateTime(sintoma.getDateTime());
        sintomaDTO.setDescription(sintoma.getDescription());
        sintomaDTO.setUserDTO(UserBuilder.fromEntity(sintoma.getUser()));
        return sintomaDTO;
    }
}
