package com.codecool.repository_DAO;

import com.codecool.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findClientsByClientName(String ClientName);
}
