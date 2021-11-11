package com.example.desenvolvimento_software_3.application.user;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User create(User apiUser) {
        User user = new User();
        user.setId(null);
        user.setSenha(apiUser.getSenha());
        user.setLogradouro(apiUser.getLogradouro());
        user.setEstado(apiUser.getEstado());
        user.setCidade(apiUser.getCidade());
        user.setCep(apiUser.getCep());
        user.setLastName(apiUser.getLastName());
        user.setFirstName(apiUser.getFirstName());

        return userRepository.save(user);
    }

    @Override
    public User getOne(Long id) throws Exception {
        Optional<User> dbUser = userRepository.findById(id);
        if (dbUser.isPresent()) {
            return dbUser.get();
        } else {
            throw new Exception("User not found!");
        }
    }

    @Override
    public User update(User fromDTO, Long userId) {
        try {
            User oldUser = getOne(userId);
            fromDTO.setId(oldUser.getId());
            return userRepository.save(fromDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return fromDTO;
        }
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
