package tn.iit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.iit.beans.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByCin(String cin);
}