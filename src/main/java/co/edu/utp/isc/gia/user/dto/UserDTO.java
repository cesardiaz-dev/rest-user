/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.user.dto;

/**
 *
 * @author DiazOspina
 */
public class UserDTO {

    private String username;
    private String password;
    private String name;
    private boolean active;

    public UserDTO() {
    }

    public UserDTO(String username, String password, String name, boolean active) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.active = active;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
