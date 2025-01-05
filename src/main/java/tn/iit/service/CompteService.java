package tn.iit.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.iit.beans.Compte;
import tn.iit.repository.CompteRepository;

import java.util.List;
@AllArgsConstructor

@Service
public class CompteService {

	private final CompteRepository compteRepository;

	public List<Compte> findByClientId(Long clientId) {
		return compteRepository.findByClientId(clientId);
	}

	public List<Compte> findAll() {
		return compteRepository.findAll();
	}

	public Compte saveOrUpdate(Compte compte) {
		return compteRepository.save(compte);
	}

	public void deleteByRib(Integer rib) {
		compteRepository.deleteById(rib);
	}

	public Compte findById(int id) {
		return compteRepository.findById(id).orElse(null);
	}
}