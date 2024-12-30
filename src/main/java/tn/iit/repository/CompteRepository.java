package tn.iit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.iit.beans.Compte;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Integer> {

	List<Compte> findByClientId(Long clientId);

}
