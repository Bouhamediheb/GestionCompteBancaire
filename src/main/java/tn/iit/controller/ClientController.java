package tn.iit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import tn.iit.beans.Client;
import tn.iit.beans.Compte; // Assuming you have a Compte class
import tn.iit.service.ClientService;
import tn.iit.service.CompteService; // Assuming you have a CompteService

import java.util.List;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;
    private final CompteService compteService;

    @GetMapping
    public ResponseEntity<List<Client>> findAll() {
        List<Client> clients = clientService.findAll();
        return ResponseEntity.ok(clients);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id) {
        Client client = clientService.findById(id);
        if (client == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(client);
    }

    @GetMapping("/{id}/comptes")
    public ResponseEntity<List<Compte>> findComptesByClientId(@PathVariable Long id) {
        List<Compte> comptes = compteService.findByClientId(id);
        if (comptes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(comptes);
    }

    @PostMapping("/save")
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        Client savedClient = clientService.saveOrUpdate(client);
        return ResponseEntity.ok(savedClient); // You can adjust the URI here if needed
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client client) {
        Client existingClient = clientService.findById(id);
        if (existingClient == null) {
            return ResponseEntity.notFound().build();
        }

        existingClient.setNom(client.getNom());
        existingClient.setPrenom(client.getPrenom());
        Client updatedClient = clientService.saveOrUpdate(existingClient);
        return ResponseEntity.ok(updatedClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}