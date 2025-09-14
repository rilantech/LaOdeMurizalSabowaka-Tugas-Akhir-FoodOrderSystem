package com.tugasakhir.foodordersystem.repository.managementuser;

import com.tugasakhir.foodordersystem.entity.managementuser.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {

    Boolean existsByEmail(String email);
    Boolean existsByEmailAndIdUserNot(String email, String idUser);
    Boolean existsByUsername(String username);
    Boolean existsByUsernameAndIdUserNot(String username, String idUser);
    Optional<User> findByUsername(String username);
}
