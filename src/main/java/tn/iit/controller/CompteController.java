package tn.iit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.iit.beans.Compte;
import tn.iit.service.CompteService;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/comptes")
public class CompteController {

	private final CompteService compteService;

	public CompteController(CompteService compteService) {
		this.compteService = compteService;
	}

	@GetMapping
	public ResponseEntity<List<Compte>> findAll() {
		List<Compte> comptes = compteService.findAll();
		if (comptes == null || comptes.isEmpty()) {
			System.out.println("No comptes found");
		}
		return ResponseEntity.ok(comptes);
	}

	@PostMapping("/saveCompte")
	public ResponseEntity<Compte> saveCompte(@RequestBody Compte compte) {
		Compte savedCompte = compteService.saveOrUpdate(compte);
		return ResponseEntity.ok(savedCompte);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable int id) {
		compteService.deleteByRib(id);
		return ResponseEntity.noContent().build();
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
    public ResponseEntity<Compte> updateCompte(@PathVariable int id, @RequestBody Compte compte) {
        Compte existingCompte = compteService.findById(id);
        if (existingCompte == null) {
            return ResponseEntity.notFound().build();
        }

        existingCompte.setSolde(compte.getSolde());
        Compte updatedCompte = compteService.saveOrUpdate(compte);

        return ResponseEntity.ok(updatedCompte);
    }

	@ResponseBody
	@PostMapping("/delete-ajax")
	public void deleteAjax(@RequestParam Integer rib) {
		compteService.deleteByRib(rib);
	}
}
