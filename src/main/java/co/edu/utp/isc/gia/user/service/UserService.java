/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.user.service;

import co.edu.utp.isc.gia.user.dto.UserDTO;
import java.util.List;

/**
 *
 * @author DiazOspina
 */
public interface UserService {
    List<UserDTO> listaUsuarios();
    
    UserDTO consultarUsuario(String username);
    
    UserDTO guardarUsuario(UserDTO user);
    
    UserDTO eliminarUsuario(String username);
}
