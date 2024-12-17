package tn.iit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import tn.iit.beans.Compte;
import tn.iit.service.CompteService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/comptes")
public class CompteController {
	private final CompteService compteService;


	@GetMapping
	public ResponseEntity<List<Compte>> findAll() {
		List<Compte> comptes = compteService.findAll();
		return ResponseEntity.ok(comptes);
	}

	@PostMapping("/save")
	public String save(@RequestParam("nomClient") String nomClient, @RequestParam("solde") float solde) {
		Compte compte = new Compte(nomClient, solde);
		compteService.saveOrUpdate(compte);
		return "redirect:/comptes/";
	}



	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable int id) {
		compteService.deleteById(id);
		return ResponseEntity.noContent().build();
	}


	@GetMapping("/search")
	public ResponseEntity<List<Compte>> search(@RequestParam("key") String key) {
		List<Compte> matchingComptes = compteService.findAllByKey(key);
		return ResponseEntity.ok(matchingComptes);
	}


	@GetMapping("/{id}")
	public ResponseEntity<Compte> findById(@PathVariable int id) {
		Compte compte = compteService.findById(id);
		if (compte == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(compte);
	}


	@PutMapping("/{id}")
	public ResponseEntity<Compte> update(@PathVariable int id, @RequestBody Compte compte) {
		Compte existingCompte = compteService.findById(id);
		if (existingCompte == null) {
			return ResponseEntity.notFound().build();
		}
		existingCompte.setNomClient(compte.getNomClient());
		existingCompte.setSolde(compte.getSolde());
		Compte updatedCompte = compteService.saveOrUpdate(existingCompte);
		return ResponseEntity.ok(updatedCompte);
	}

	// Delete via AJAX (optional)
	@PostMapping("/delete-ajax")
	public ResponseEntity<Void> deleteAjax(@RequestParam Integer rib) {
		compteService.deleteById(rib);
		return ResponseEntity.noContent().build();
	}
}
