package com.example.desenvolvimento_software_3.application.sintoma;

import com.example.desenvolvimento_software_3.application.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SintomaServiceImpl implements SintomaService {

    private SintomaRepository sintomaRepository;
    private UserService userService;

    public SintomaServiceImpl(SintomaRepository sintomaRepository, UserService userService) {
        this.sintomaRepository = sintomaRepository;
        this.userService = userService;
    }

    @Override
    public List<Sintoma> getAll() {
        return sintomaRepository.findAll();
    }

    @Override
    public Sintoma create(Sintoma apiSintoma, Long userId) {
        Sintoma sintoma = new Sintoma();
        sintoma.setId(null);
        sintoma.setDescription(apiSintoma.getDescription());
        sintoma.setDateTime(apiSintoma.getDateTime());
        try {
            sintoma.setUser(userService.getOne(userId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sintomaRepository.save(sintoma);
    }

    @Override
    public Sintoma getOne(Long id) throws Exception {
        Optional<Sintoma> dbSintoma = sintomaRepository.findById(id);
        if (dbSintoma.isPresent()) {
            return dbSintoma.get();
        } else {
            throw new Exception("Sintoma not found!");
        }
    }

    @Override
    public Sintoma update(Sintoma fromDTO, Long sintomaId) {
        try {
            Sintoma oldSintoma = getOne(sintomaId);
            fromDTO.setId(oldSintoma.getId());
            return sintomaRepository.save(fromDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return fromDTO;
        }
    }

    @Override
    public void delete(Long id) {
        sintomaRepository.deleteById(id);
    }
}
