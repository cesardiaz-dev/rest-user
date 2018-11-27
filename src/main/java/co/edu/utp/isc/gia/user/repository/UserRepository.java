/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.user.repository;

import co.edu.utp.isc.gia.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DiazOspina
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {
    
}
