/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.user.web;

import co.edu.utp.isc.gia.user.dto.UserDTO;
import co.edu.utp.isc.gia.user.service.UserService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DiazOspina
 */
@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<UserDTO> listaUsuarios = userService.listaUsuarios();
        if(listaUsuarios == null || listaUsuarios.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        
        return ResponseEntity.ok(listaUsuarios);
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getUser(@PathVariable("username") String username) {
        UserDTO usuario = userService.consultarUsuario(username);
        
        if(usuario == null){
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public ResponseEntity<?> insertUser(@RequestBody UserDTO usuario) {
        UserDTO user = userService.consultarUsuario(usuario.getUsername());
        
        if(user != null){
            return ResponseEntity.badRequest().build();
        }

        usuario = userService.guardarUsuario(usuario);
        
        if(usuario == null){
            return ResponseEntity.badRequest().build();
        }
        
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/{username}")
    public ResponseEntity<?> updateUser(
            @PathVariable("username") String username,
            @RequestBody UserDTO user) {
        UserDTO usuario = userService.consultarUsuario(username);
        
        if(usuario == null){
            return ResponseEntity.notFound().build();
        }
        
        usuario = userService.guardarUsuario(user);
        
        if(usuario == null){
            return ResponseEntity.badRequest().build();
        }
        
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable("username") String username) {
        UserDTO usuario = userService.eliminarUsuario(username);
        
        if(usuario == null){
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(usuario);
    }
}
