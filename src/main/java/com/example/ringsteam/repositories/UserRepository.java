package com.example.ringsteam.repositories;

import com.example.ringsteam.models.UserSteam;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserSteam, Long> {
    boolean existsUserSteamByUsername(String username);

    Optional<UserSteam> findByUsername(String username);
}
