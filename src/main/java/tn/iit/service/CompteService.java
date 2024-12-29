package tn.iit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tn.iit.beans.Compte;
import tn.iit.exception.CompteNotFoundException;
import tn.iit.repository.CompteRepository;

@RequiredArgsConstructor
@Service
public class CompteService {
	private final CompteRepository compteRepository;
	public Compte saveOrUpdate(Compte compte) {
		return compteRepository.save(compte);
	}

	public List<Compte> findAll() {
		return compteRepository.findAll();
	}
	public void deleteById(Integer rib) {
		compteRepository.deleteById(rib);
	}
	public List<Compte> findAllByKey(String key) {
		return compteRepository.findByNomClientContains(key);
	}
	public Compte findById(Integer rib) {
		return compteRepository.findById(rib).orElseThrow(() -> new CompteNotFoundException("Compte with rib = " + rib + " is not found"));

	}

}
