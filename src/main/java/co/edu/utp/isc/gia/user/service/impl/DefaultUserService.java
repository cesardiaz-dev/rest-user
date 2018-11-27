/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.user.service.impl;

import co.edu.utp.isc.gia.user.dto.UserDTO;
import co.edu.utp.isc.gia.user.entity.User;
import co.edu.utp.isc.gia.user.repository.UserRepository;
import co.edu.utp.isc.gia.user.service.UserService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DiazOspina
 */
@Service
public class DefaultUserService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> listaUsuarios() {
        List<UserDTO> respuesta = null;
        List<User> users = userRepository.findAll();
        if (users != null && !users.isEmpty()) {
            respuesta = new ArrayList<>();
            for (User user : users) {
                respuesta.add(userToDto(user));
            }
        }
        return respuesta;
    }

    @Override
    public UserDTO consultarUsuario(String username) {
        Optional<User> userOptional = userRepository.findById(username);
        if(userOptional.isPresent()){
            return userToDto(userOptional.get());        
        }
        return null;
    }

    @Override
    public UserDTO guardarUsuario(UserDTO user) {
        User usuario = userRepository.save(dtoToUser(user));
        return userToDto(usuario);
    }

    @Override
    public UserDTO eliminarUsuario(String username) {
        UserDTO usuario = consultarUsuario(username);
        if(usuario != null){
            userRepository.deleteById(username);
            return usuario;
        }
        
        return null;
    }

    private UserDTO userToDto(User user) {
        return new UserDTO(user.getUsername(),
                user.getPassword(),
                user.getName(),
                user.isActive());
    }
    
    private User dtoToUser(UserDTO user){
        User resp = new User();
        resp.setUsername(user.getUsername());
        resp.setPassword(user.getPassword());
        resp.setName(user.getName());
        resp.setActive(user.isActive());
        return resp;
    }

}
