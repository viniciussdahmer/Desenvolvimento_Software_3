package com.example.desenvolvimento_software_3.application.sintoma;

import java.util.List;

public interface SintomaService {

    List<Sintoma> getAll();

    Sintoma create(Sintoma sintoma, Long userId);

    Sintoma getOne(Long id) throws Exception;

    Sintoma update(Sintoma fromDTO, Long sintomaId);

    void delete(Long id);
}
