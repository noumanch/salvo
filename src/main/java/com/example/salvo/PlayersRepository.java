package com.example.salvo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;
import java.util.*;
import java.sql.*;

@RepositoryRestResource
public interface PlayersRepository extends JpaRepository<Player, Long> {
    //List<Player> findByLastName(String lastName);
}
